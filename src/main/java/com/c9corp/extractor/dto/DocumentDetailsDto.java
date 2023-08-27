package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class DocumentDetailsDto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(content = JsonInclude.Include.NON_NULL)
public class DocumentDetailsDto extends BaseDto {

    private Integer totalPages;

    @Builder.Default
    private List<PageDetailsDto> pageDetails = new ArrayList<>();
}
