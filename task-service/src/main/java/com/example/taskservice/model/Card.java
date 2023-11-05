package com.example.taskservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "card")
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Column(name = "list_id")
    private TaskList taskList;

    private String name;

    private String description;

    private String position;

    private Instant created_at;


    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CardLabel> labels;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CardAttachment> attachments;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<ActivityLog> activityLogs;

}
