package com.example.taskservice.dto.mapper;


import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.model.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto toDto(Board board);

    Board toModel(BoardDto boardDto);

    List<BoardDto> toDtoList(List<Board> list);

    List<Board> toModelList(List<BoardDto> list);
}
