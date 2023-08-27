package com.c9corp.extractor.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExtractData {
    private int type;
    private String value;
    private double height;
    private double width;
    private double xCoordinate;
    private double yCoordinate;
    private double confScore;
}
