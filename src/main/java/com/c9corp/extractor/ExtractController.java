package com.c9corp.extractor;


import com.c9corp.extractor.dto.ExtractResponse;
import com.c9corp.extractor.dto.ExtractedDocDto;
import com.c9corp.extractor.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*")
public class ExtractController {

    @Autowired
    ExtractionService extractionService;
    @PostMapping(value = "/extractFile")
    public ResponseEntity<ResponseDto<ExtractResponse>> extractDoc(@RequestParam MultipartFile file,
                                                                   @RequestParam(required = false, defaultValue = "3") int extractType,
                                                                   @RequestParam(required = false, defaultValue = "false") boolean extractCoordinates) throws IOException, ExecutionException, InterruptedException {
        var response = extractionService.extractFile(file, extractType, extractCoordinates);
        return ResponseEntity.ok(ResponseDto.build(response));
    }


    @PostMapping(value = "/extractImage")
    public ResponseEntity<byte[]> extractImage(@RequestParam MultipartFile file,
                                                                   @RequestParam(required = false, defaultValue = "1") int pageNum) throws IOException {
        var response = extractionService.extractImageInBytes(file, pageNum);
        return ResponseEntity.ok(response);
    }

}
