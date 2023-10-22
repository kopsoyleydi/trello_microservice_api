package com.example.task_service.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateUserCategoryDTO {
    Long id;

    String name;

    String description;

    Long userId;
}
