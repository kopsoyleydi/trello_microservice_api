package com.example.taskservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardLabelDto {

    private Long id;

    @ManyToOne
    private CardDto card;

    private String color;
}
