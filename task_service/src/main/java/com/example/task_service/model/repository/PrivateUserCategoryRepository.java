package com.example.task_service.model.repository;

import com.example.task_service.model.PrivateUserCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PrivateUserCategoryRepository extends JpaRepository<PrivateUserCategory, Long> {

    PrivateUserCategory getPrivateUserCategoriesByUserId(Long id);
}
