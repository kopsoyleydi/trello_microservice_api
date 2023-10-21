package com.example.task_service.dto;

import com.example.task_service.model.Category;
import com.example.task_service.model.PrivateUserCategory;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDTO {

    Long id;

    Long userId;

    @ManyToOne
    Category category;

    @Builder.Default
    Instant createAt = Instant.now();

    String header;

    String description;

    String linkToAWSCloud;

    String comments;

    Boolean check;

    @ManyToMany
    List<PrivateUserCategory> privateUserCategories;
}
