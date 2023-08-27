package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExtractResponse {
    List<PageExtractedData> extractedPages;
}
