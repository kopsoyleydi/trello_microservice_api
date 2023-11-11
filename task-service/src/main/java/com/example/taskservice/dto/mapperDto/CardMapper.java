package com.example.taskservice.dto.mapperDto;


import com.example.taskservice.dto.CardDto;
import com.example.taskservice.model.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto toDto(Card card);

    Card toModel(CardDto cardDto);

    List<CardDto> toDtoList(List<Card> list);

    List<Card> toModelList(List<CardDto> list);
}
