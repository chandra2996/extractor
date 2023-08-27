package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtractedDocDto extends BaseDto {

    private String docPath;

    @Builder.Default
    private List<ExtractedPageDto> extractedDetails = new ArrayList<>();
}
