package com.example.taskservice.dto;

import com.example.taskservice.model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private Long id;

    @OneToOne
    private TaskList taskList;

    private String name;

    private String description;

    private String position;

    private Instant created_at;


    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CardLabelDto> labels;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CardAttachmentDto> attachments;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CommentDto> comments;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<ActivityLog> activityLogs;
}
