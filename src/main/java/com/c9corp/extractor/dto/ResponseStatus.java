package com.c9corp.extractor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * The class ResponseStatusDto.
 */
@Getter
@NoArgsConstructor
public class ResponseStatus extends BaseDto {

    private Integer value;

    private String phrase;

    public ResponseStatus(final HttpStatus status) {
        this.value = status.value();
        this.phrase = status.getReasonPhrase();
    }

}
