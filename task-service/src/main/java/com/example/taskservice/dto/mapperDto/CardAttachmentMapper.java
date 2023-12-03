package com.example.taskservice.dto.mapperDto;


import com.example.taskservice.dto.dtos.CardAttachmentDto;
import com.example.taskservice.model.CardAttachment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardAttachmentMapper {

    CardAttachmentDto toDto(CardAttachment cardAttachment);

    CardAttachment toModel(CardAttachmentDto cardAttachmentDto);

    List<CardAttachmentDto> toDtoList(List<CardAttachment> list);

    List<CardAttachment> toModelList(List<CardAttachmentDto> list);
}
