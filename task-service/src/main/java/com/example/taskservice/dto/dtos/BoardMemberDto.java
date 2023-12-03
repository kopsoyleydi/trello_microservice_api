package com.example.taskservice.dto.dtos;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardMemberDto {

    private Long id;

    @ManyToMany
    private List<UserDto> users;

    private String role;
}
