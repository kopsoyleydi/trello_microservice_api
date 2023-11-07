package com.example.taskservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "list")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskList {

    @Id
    @Column(name = "list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "created_at")
    private Instant created_at;

}
