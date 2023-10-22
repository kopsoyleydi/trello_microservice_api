package com.example.task_service.model.ModelImpliments;


import com.example.task_service.model.Comments;
import com.example.task_service.model.repository.CommentRepository;
import com.example.task_service.model.repository.repoIMPL.CommentRepoInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentIMPL implements CommentRepoInter {

    private final CommentRepository commentRepository;

    @Override
    public Comments addComment(Comments comments) {
        return commentRepository.save(comments);
    }

    @Override
    public List<Comments> getAllCommentsByTaskIdAndUserId(Long userId, Long taskId) {
        return commentRepository.getCommentsByTaskIdAndUserId(userId, taskId);
    }

    @Override
    public Comments changeCommentByUserIdAndTaskId(Long userId, Long taskId, String comment) {
        return commentRepository.changeCommentByTaskIdWithUserId(userId, taskId, comment);
    }
}
