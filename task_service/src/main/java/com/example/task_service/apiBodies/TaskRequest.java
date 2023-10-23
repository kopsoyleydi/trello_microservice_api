package com.example.task_service.apiBodies;

import com.example.task_service.dto.CategoryDTO;
import com.example.task_service.dto.PrivateUserCategoryDTO;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class TaskRequest {

    Long userId;

    Long categoryId;

    @Builder.Default
    Instant createAt = Instant.now();

    String header;

    String description;

    String linkToAWSCloud;

    String comments;

    Boolean check;

    List<PrivateUserCategoryDTO> privateUserCategories;
}
