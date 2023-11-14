package com.example.taskservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
