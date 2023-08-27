package com.c9corp.extractor;

import com.c9corp.extractor.dto.Coordinates;
import com.c9corp.extractor.dto.ExtractResponse;
import com.c9corp.extractor.dto.PageExtractedData;
import com.c9corp.extractor.dto.Word;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract1;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Service
@RequiredArgsConstructor
public class ExtractionService {


    public ExtractResponse extractFile(MultipartFile file, int extractType, boolean extractCoordinates) throws IOException, ExecutionException, InterruptedException {

        try (InputStream inputStream = file.getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {
            List<PageExtractedData> extractedPageData = new ArrayList<>();
            if (document.getDocumentCatalog().getAcroForm() == null) {
                document.getDocumentCatalog().getPages().forEach(pdPage -> pdPage.setAnnotations(null));
            }
            ExecutorService fixedTHreadExecutor = Executors.newFixedThreadPool(2);
            List<Future<PageExtractedData>> futureExtractList = new ArrayList<>();
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int pageIndex = 0; pageIndex < document.getNumberOfPages(); pageIndex++) {
                boolean isUseTextract = false;
                BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(pageIndex, 300, ImageType.BINARY);
                try {
                    int finalPageIndex = pageIndex;
                    Future<PageExtractedData> futureExtract = fixedTHreadExecutor.submit(() -> {
                        ITesseract tesseract = new Tesseract1();
                        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
                        tesseract.setLanguage("eng");
                        tesseract.setPageSegMode(1);
                        tesseract.setOcrEngineMode(1);
                        PageExtractedData pageData = extractFile(tesseract, bufferedImage, extractType, extractCoordinates);
                        if (!ObjectUtils.isEmpty(pageData)) {
                            pageData.setPageNumber(finalPageIndex + 1);
                        }
                        return pageData;
                    });
                    futureExtractList.add(futureExtract);
                } catch (Exception e) {
                    isUseTextract = true;
                }
            }
            for (Future<PageExtractedData> futureExtract : futureExtractList) {
                var response = futureExtract.get();
                extractedPageData.add(response);

            }
            return ExtractResponse.builder().extractedPages(extractedPageData).build();
        } catch (Exception exception) {
            throw exception;
        }
    }


    public PageExtractedData extractFile(ITesseract tesseract, BufferedImage bufferedImage, int extractType, boolean extractCoordinates) {
        final List<Word> texts = new ArrayList<>();
        try {
            final int pageHeight = bufferedImage.getHeight();
            final int pageWidth = bufferedImage.getWidth();

            final List<net.sourceforge.tess4j.Word> words = tesseract.getWords(bufferedImage, extractType);
            words.forEach(word -> {
                try {
                    Word textDto = Word.builder().text(word.getText()).confidence((double) word.getConfidence())
                            .build();
                    if (extractCoordinates) {
                        final Coordinates coordinates = Coordinates.builder().x(word.getBoundingBox().getX())
                                .y(word.getBoundingBox().getY()).height(word.getBoundingBox().getHeight())
                                .width(word.getBoundingBox().getWidth()).build();
                        textDto.setCoordinates(coordinates);
                    }
                    texts.add(textDto);
                } catch (final Exception ex) {
                    throw ex;
                }
            });
            return buildTextDetails(texts, (double) pageHeight, (double) pageWidth, "Image", "Tesseract");
        } catch (final Throwable ex) {
            throw ex;
        }
    }

    PageExtractedData buildTextDetails(List<Word> texts, Double pageHeight, Double pageWidth, String pageType, String engine) {
        return PageExtractedData.builder().textDetails(texts).pageHeight(pageHeight)
                .pageWidth(pageWidth).pageType(pageType)
                .unit("Pixels").extractionEngine(engine).build();
    }


    public byte[] extractImageInBytes(MultipartFile file, int pageNum) throws IOException {
        try (InputStream inputStream = file.getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {
            if (document.getDocumentCatalog().getAcroForm() == null) {
                document.getDocumentCatalog().getPages().forEach(pdPage -> pdPage.setAnnotations(null));
            }
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(pageNum - 1, 300, ImageType.BINARY);
            try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
                ImageIO.write(bufferedImage, "jpeg", os);
                return os.toByteArray();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }
}
