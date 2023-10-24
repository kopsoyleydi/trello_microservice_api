package com.example.task_service.apiBodies;


import lombok.Data;

@Data
public class PrivateUserCategoryRequest {
    Long id;
    String name;
    String description;
    Long userId;
}
