package com.example.task_service.dto.mapper;


import com.example.task_service.dto.CommentDTO;
import com.example.task_service.model.Comments;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO toDto(Comments category);

    Comments toModel(CommentDTO commentDTO);

    List<CommentDTO> toDtoList(List<Comments> list);

    List<Comments> toModelList(List<CommentDTO> list);
}
