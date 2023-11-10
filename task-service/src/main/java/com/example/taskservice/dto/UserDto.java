package com.example.taskservice.dto;

import com.example.taskservice.model.BoardMember;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String email;

    @ManyToMany(mappedBy = "users")
    private List<BoardMemberDto> boardMembers;
}
