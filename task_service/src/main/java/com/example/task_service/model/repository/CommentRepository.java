package com.example.task_service.model.repository;

import com.example.task_service.model.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comments, Long> {

    Comments getCommentsByUserId(Long userId);
}
