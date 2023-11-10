package com.example.taskservice.dto;

import com.example.taskservice.model.Card;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardAttachmentDto {

    private Long id;

    @ManyToOne
    private Card card;

    private String awsLink;
}
