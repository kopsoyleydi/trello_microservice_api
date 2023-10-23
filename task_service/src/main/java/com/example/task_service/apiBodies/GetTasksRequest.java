package com.example.task_service.apiBodies;

import lombok.Data;

@Data
public class GetTasksRequest {
    Long userId;

    Long categoryId;
}
