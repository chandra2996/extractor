package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.util.ObjectUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtractedFieldDto extends BaseDto {

    private Double height;

    private Double width;

    private Double x;

    private Double y;

    private String label;

    @Builder.Default
    private String value = "";

    private Integer index;

    private String fieldType;
    
    private String regexText;
    
    private String regex;


}
