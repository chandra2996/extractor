package com.c9corp.extractor.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageExtractionDto extends BaseDto {

    private String pagePath;

    private String uniqueDocumentId;

    private String packageId;

    private String loanNumber;

    private String uniquePageId;

    private String sourceSystemName;

    private String icrMode;

    private String docId;

    private String docName;

    private String clientId;

    private String userId;

}
