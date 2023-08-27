package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * The class ResponseDto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(content = JsonInclude.Include.NON_EMPTY)
public class ResponseDto<T> extends BaseDto {

    private T data;

    private Boolean isErrorred;

    private ResponseStatusDto status;

    public static <U> ResponseDto<U> build(final U u) {
        return ResponseDto.<U>builder().status(new ResponseStatusDto(HttpStatus.OK))
                .data(u).build();
    }

    public static <U> ResponseDto<U> build(final U u, final HttpStatus status) {
        return ResponseDto.<U>builder().status(new ResponseStatusDto(status))
                .data(u).build();
    }

    public static <U> ResponseDto<U> buildError(final U u) {
        return ResponseDto.<U>builder().status(new ResponseStatusDto(HttpStatus.INTERNAL_SERVER_ERROR))
                .isErrorred(Boolean.TRUE).data(u)
                .build();
    }

    public static <U> ResponseDto<U> buildError(final U u, final HttpStatus status) {
        return ResponseDto.<U>builder().status(new ResponseStatusDto(status))
                .isErrorred(Boolean.TRUE).data(u)
                .build();
    }
}
