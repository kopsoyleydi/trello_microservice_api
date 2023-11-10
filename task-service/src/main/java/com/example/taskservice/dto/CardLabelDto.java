package com.example.taskservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardLabelDto {

    private Long id;

    @ManyToOne
    private CardDto card;

    private String color;
}
