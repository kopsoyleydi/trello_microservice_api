package com.example.taskservice.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardLabelDto {

    private Long id;

    @ManyToOne
    private CardDto card;

    private String color;
}
