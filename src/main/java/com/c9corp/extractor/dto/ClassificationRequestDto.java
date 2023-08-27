package com.c9corp.extractor.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassificationRequestDto extends BaseDto {

    private String docPath;

    private String pagePath;

    private String metaData;

    private String uniqueDocumentId;

    private String packageId;

    private String loanNumber;

    private String uniquePageId;

    private String sourceSystemName;

}
