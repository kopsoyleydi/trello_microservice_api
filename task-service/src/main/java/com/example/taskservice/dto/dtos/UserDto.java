package com.example.taskservice.dto.dtos;


import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String email;

    @ManyToMany(mappedBy = "users")
    private List<BoardMemberDto> boardMembers;
}
