package com.example.task_service.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity(name = "tasks")
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

    @Column(name = "description")
    String description;

    @Column(name = "picture")
    String linkToAWSCloud;

    @Column(name = "comments")
    String comments;

    @Column(name = "check")
    Boolean check;
}
