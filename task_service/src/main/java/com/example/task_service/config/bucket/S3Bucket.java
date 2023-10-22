package com.example.task_service.config.bucket;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("aws.s3.buckets")
public class S3Bucket {
    private String customer;

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
