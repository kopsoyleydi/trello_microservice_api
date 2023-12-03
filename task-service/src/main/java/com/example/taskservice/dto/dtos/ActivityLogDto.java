package com.example.taskservice.dto.dtos;



import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogDto {

    private Long id;

    @ManyToOne
    private CardDto card;

    @ManyToOne
    private UserDto user;

    private String actionType;

    private String target_type;

    private Instant created_at;
}
