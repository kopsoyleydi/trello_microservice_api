package com.example.task_service.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "comments")
    String comment;

    @Column(name = "task_id")
    @ManyToOne
    Task task;

    @Column(name = "user_id")
    Long userId;
}
