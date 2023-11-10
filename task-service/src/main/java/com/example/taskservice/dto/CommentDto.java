package com.example.taskservice.dto;

import com.example.taskservice.model.Card;
import com.example.taskservice.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {


    private Long id;

    @ManyToOne
    private CardDto card;

    @ManyToOne
    private UserDto user;

    private String text;

    private Instant created_at;
}
