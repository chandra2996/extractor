package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtractedPageDto extends BaseDto {

    private Double pgWidth;

    private Double pgHeight;

    private Integer pgNo;

    private List<ExtractedFieldDto> fields;

}
