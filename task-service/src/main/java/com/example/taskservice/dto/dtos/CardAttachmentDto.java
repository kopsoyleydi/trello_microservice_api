package com.example.taskservice.dto.dtos;


import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardAttachmentDto {

    private Long id;

    @ManyToOne
    private CardDto card;

    private String awsLink;
}
