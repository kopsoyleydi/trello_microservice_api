package com.example.taskservice.bodies;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TaskBody {

    private Long id;

    private Long boardId;

    private String name;

    private String position;

    private Instant created_at;
}
