package com.example.taskservice.dto.response;

import com.example.taskservice.dto.BoardDto;
import jakarta.persistence.ManyToOne;
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
