package com.example.taskservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskListDto {


    private Long id;

    @ManyToOne
    private BoardDto board;

    private String name;

    private String position;

    private Instant created_at;
}
