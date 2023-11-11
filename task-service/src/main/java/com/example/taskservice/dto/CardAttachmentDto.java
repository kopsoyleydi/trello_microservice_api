package com.example.taskservice.dto;


import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardAttachmentDto {

    private Long id;

    @ManyToOne
    private CardDto card;

    private String awsLink;
}
