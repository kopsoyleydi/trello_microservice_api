package com.example.task_service.dto.mapper;

import com.example.task_service.dto.CategoryDTO;
import com.example.task_service.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);

    Category toModel(CategoryDTO busDTO);

    List<CategoryDTO> toDtoList(List<Category> list);

    List<Category> toModelList(List<CategoryDTO> list);
}
