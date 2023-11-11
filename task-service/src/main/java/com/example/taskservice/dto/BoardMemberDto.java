package com.example.taskservice.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardMemberDto {

    private Long id;

    @ManyToMany
    private List<UserDto> users;

    private String role;
}
