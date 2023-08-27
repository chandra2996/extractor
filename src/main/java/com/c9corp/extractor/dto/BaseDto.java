package com.c9corp.extractor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * The class BaseDto
 * This is the base class for all the DTO
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto {
}
