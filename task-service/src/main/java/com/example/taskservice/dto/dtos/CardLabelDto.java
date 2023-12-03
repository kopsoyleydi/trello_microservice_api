package com.example.taskservice.dto.dtos;

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
