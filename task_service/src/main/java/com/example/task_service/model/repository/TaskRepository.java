package com.example.task_service.model.repository;


import com.example.task_service.model.Category;
import com.example.task_service.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task getAllByUserId(Long userId);

    @Query("select t from tasks t where t.userId = :userId and t.category.id = :categoryId")
    List<Task> getTasksByUserIdAndCategoryId(Long userId, Long categoryId);

    @Query("delete from tasks t where t.userId = :userId and t.category.id = :categoryId")
    void deleteByUserIdAndCategoryId(Long userId, Long categoryId);

}
