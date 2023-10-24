package com.example.task_service.controller;

import com.example.task_service.dto.CategoryDTO;
import com.example.task_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task/category")
public class CategoryController {

    private final CategoryService categoryService;

    public List<CategoryDTO> getAllCategories(){
        return categoryService.getCategories();
    }
}
