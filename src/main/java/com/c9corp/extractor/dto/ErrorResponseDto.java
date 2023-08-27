package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * The class ErrorResponseDto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponseDto<T> extends BaseDto {

    private String message;

    private T error;
}
