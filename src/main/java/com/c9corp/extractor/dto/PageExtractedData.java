package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class PageDetailsDto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageExtractedData extends BaseDto {

    private Integer pageNumber;

    private Double pageWidth;

    private Double pageHeight;

    private Double originalPageWidth;

    private Double originalPageHeight;

    private Double pageSize;

    private String unit;

    private String pageType;

    private String extractionEngine;

    private String pagePath;

    private List<Word> textDetails = new ArrayList<>();
}
