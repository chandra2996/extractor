package com.c9corp.extractor.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EpsSqsPayloadDto {

    private String pagePath;

    private String uniqueDocumentId;

    private String packageId;

    private String loanNumber;

    private String uniquePageId;

    private String sourceSystemName;

    private String extractedPagePath;

    private String extractionEngine;

    private String pageError;

    private String icrMode;

    private String docId;

    private String docName;

    private Double pageSize;

    private String clientId;

    private String userId;

}
