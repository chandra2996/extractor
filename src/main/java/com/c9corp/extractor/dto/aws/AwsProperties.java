package com.c9corp.extractor.dto.aws;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AwsProperties {
    private S3Properties s3;
    private QueueProperties queue;
}
