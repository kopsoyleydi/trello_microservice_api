package com.example.task_service.model.ModelImpliments;

import com.example.task_service.model.Category;
import com.example.task_service.model.repository.CategoryRepository;
import com.example.task_service.model.repository.repoIMPL.CategoryRepoInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryIMPL implements CategoryRepoInter {

    private final CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category changeCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findAllById(id);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }


}
