package com.example.taskservice.dto.mapper;


import com.example.taskservice.dto.CardDto;
import com.example.taskservice.dto.CardLabelDto;
import com.example.taskservice.model.Card;
import com.example.taskservice.model.CardLabel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardLabelMapper {

    CardLabelDto toDto(CardLabel cardLabel);

    CardLabel toModel(CardLabelDto cardLabelDto);

    List<CardLabelDto> toDtoList(List<CardLabel> list);

    List<CardLabel> toModelList(List<CardLabelDto> list);
}
