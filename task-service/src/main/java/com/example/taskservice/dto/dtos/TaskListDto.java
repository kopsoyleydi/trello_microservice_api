package com.example.taskservice.dto.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "board_id")
    @JsonBackReference
    private BoardDto board;

    private String name;

    private String position;

    private Instant created_at;
}
