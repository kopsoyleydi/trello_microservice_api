package com.example.taskservice.dto;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
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
