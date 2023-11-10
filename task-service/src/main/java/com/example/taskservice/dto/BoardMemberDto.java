package com.example.taskservice.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardMemberDto {

    private Long id;

    @ManyToMany
    private List<UserDto> users;

    private String role;
}
