package com.c9corp.extractor.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetryOrRerouteDto {
    private String uniqueDocumentId;
    private String loanNumber;
    private String packageId;
    private String uniquePageId;

    public static RetryOrRerouteDto build(final PageExtractionDto dto) {
        return RetryOrRerouteDto.builder()
                .uniqueDocumentId(dto.getUniqueDocumentId())
                .loanNumber(dto.getLoanNumber())
                .packageId(dto.getPackageId())
                .uniquePageId(dto.getUniquePageId())
                .build();
    }
}
