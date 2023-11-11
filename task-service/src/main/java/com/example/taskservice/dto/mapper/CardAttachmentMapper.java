package com.example.taskservice.dto.mapper;


import com.example.taskservice.dto.CardAttachmentDto;
import com.example.taskservice.dto.CardLabelDto;
import com.example.taskservice.model.CardAttachment;
import com.example.taskservice.model.CardLabel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardAttachmentMapper {

    CardAttachmentDto toDto(CardAttachment cardAttachment);

    CardAttachment toModel(CardAttachmentDto cardAttachmentDto);

    List<CardLabelDto> toDtoList(List<CardAttachment> list);

    List<CardAttachment> toModelList(List<CardAttachmentDto> list);
}
