package com.example.task_service.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalTime;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category")
    @ManyToOne
    Category category;

    @Column(name = "createAt")
    @Builder.Default
    Instant createAt = Instant.now();

    @Column(name = "header")
    String header;

    @Column(name = "text")
    String text;

    @Column(name = "picture")
    String linkToAWSCloud;

    @Column(name = "in_tasks")
    @ManyToOne
    INTasks inTasks;
}
