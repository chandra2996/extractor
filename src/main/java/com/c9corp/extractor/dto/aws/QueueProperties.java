package com.c9corp.extractor.dto.aws;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueProperties {
    private String auditLogQueue;

    private String pageExtractionRequestQueue;

    private String pageExtractionResponseQueue;

    private String templateExtractionRequestQueue;

    private String templateExtractionResponseQueue;


}
