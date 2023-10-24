package com.example.task_service.service;


import com.example.task_service.dto.CategoryDTO;
import com.example.task_service.dto.mapper.CategoryMapper;
import com.example.task_service.model.ModelImpliments.CategoryIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryIMPL categoryIMPL;

    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getCategories(){
        return categoryMapper.toDtoList(categoryIMPL.getAllCategories());
    }
}
