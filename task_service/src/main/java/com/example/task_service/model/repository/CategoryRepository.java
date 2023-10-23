package com.example.task_service.model.repository;


import com.example.task_service.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.id = :id")
    Category getCategoriesById(Long id);

    Category findAllById(Long id);

}
