package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * The class ExtractedPagedPathDto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(content = JsonInclude.Include.NON_NULL)
public class ExtractedPagedPathDto extends BaseDto {

    private String pagePath;

    private String extractedPagePath;
}
