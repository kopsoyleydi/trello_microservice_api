package com.example.taskservice.dto;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long id;

    private String name;

    private Instant created_at;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TaskListDto> lists;
}
