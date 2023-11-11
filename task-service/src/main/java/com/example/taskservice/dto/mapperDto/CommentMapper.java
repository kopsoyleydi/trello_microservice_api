package com.example.taskservice.dto.mapperDto;


import com.example.taskservice.dto.CommentDto;
import com.example.taskservice.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto toDto(Comment comment);

    Comment toModel(CommentDto comment);

    List<CommentDto> toDtoList(List<Comment> list);

    List<Comment> toModelList(List<CommentDto> list);
}
