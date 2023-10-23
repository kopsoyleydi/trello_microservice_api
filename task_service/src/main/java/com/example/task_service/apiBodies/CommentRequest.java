package com.example.task_service.apiBodies;

import com.example.task_service.dto.TaskDTO;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CommentRequest {
    String comment;

    Long taskId;

    Long userId;
}
