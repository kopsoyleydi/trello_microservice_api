package com.example.taskservice.dto.mapper;


import com.example.taskservice.dto.BoardMemberDto;
import com.example.taskservice.model.BoardMember;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMemberMapper {

    BoardMemberDto toDto(BoardMember boardMember);

    BoardMember toModel(BoardMemberDto boardMemberDto);

    List<BoardMemberDto> toDtoList(List<BoardMember> list);

    List<BoardMember> toModelList(List<BoardMemberDto> list);
}
