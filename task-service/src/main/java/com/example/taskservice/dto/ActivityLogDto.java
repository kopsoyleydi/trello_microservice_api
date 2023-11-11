package com.example.taskservice.dto;



import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
