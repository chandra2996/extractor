package com.c9corp.extractor.dto.aws;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class S3Properties {

    private String bucketName;

    private String extractionOutputFolderPath;
}
