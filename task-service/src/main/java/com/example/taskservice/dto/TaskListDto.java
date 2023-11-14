package com.example.taskservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
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
