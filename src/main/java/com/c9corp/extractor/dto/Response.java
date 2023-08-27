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
public class Response<T> extends BaseDto {

    private T data;

    private Boolean isErrorred;

    private ResponseStatus status;

    public static <U> Response<U> build(final U u) {
        return Response.<U>builder().status(new ResponseStatus(HttpStatus.OK))
                .data(u).build();
    }

    public static <U> Response<U> build(final U u, final HttpStatus status) {
        return Response.<U>builder().status(new ResponseStatus(status))
                .data(u).build();
    }

    public static <U> Response<U> buildError(final U u) {
        return Response.<U>builder().status(new ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR))
                .isErrorred(Boolean.TRUE).data(u)
                .build();
    }

    public static <U> Response<U> buildError(final U u, final HttpStatus status) {
        return Response.<U>builder().status(new ResponseStatus(status))
                .isErrorred(Boolean.TRUE).data(u)
                .build();
    }
}
