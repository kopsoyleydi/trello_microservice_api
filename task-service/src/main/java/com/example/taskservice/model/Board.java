package com.example.taskservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private Instant create_at;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TaskList> lists;


}
