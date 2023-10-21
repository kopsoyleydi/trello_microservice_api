package com.example.task_service.dto;

import com.example.task_service.model.Task;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDTO {

    Long id;

    String comment;

    @ManyToOne
    TaskDTO task;

    Long userId;
}
