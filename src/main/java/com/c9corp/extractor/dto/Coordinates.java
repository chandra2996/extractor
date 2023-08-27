package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * The class CoordinatesDto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Coordinates extends BaseDto {

    private Double x;

    private Double y;

    private Double width;

    private Double height;
}
