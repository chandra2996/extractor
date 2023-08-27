package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FullDataExtractDto {

    private String templateId;

    private String docPath;

    private String extractedDocPath;

    private List<FullPageExtractDto> pageData;

    private boolean isAsyncRequest = false;
}
