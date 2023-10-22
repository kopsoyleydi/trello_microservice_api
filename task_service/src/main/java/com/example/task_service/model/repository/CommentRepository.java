package com.example.task_service.model.repository;

import com.example.task_service.model.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comments, Long> {

    Comments getCommentsByUserId(Long userId);

    @Query(value = "UPDATE Comments c " +
            "SET c.comment = :comment " +
            "WHERE c.userId = :userId " +
            "AND c.task.id = :taskId")
    Comments changeCommentByTaskIdWithUserId(Long userId, Long taskId, String comment);

    @Query(value = "select c from Comments c where c.userId = :userId and c.task.id = :taskId")
    List<Comments> getCommentsByTaskIdAndUserId(Long userId, Long taskId);

}
