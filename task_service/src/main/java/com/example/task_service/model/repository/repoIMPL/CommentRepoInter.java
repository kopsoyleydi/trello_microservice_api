package com.example.task_service.model.repository.repoIMPL;

import com.example.task_service.model.Comments;

import java.util.List;

public interface CommentRepoInter {

    Comments addCommentByTaskIdWithUserId(Long userId, Long taskId, Comments comments);

    List<Comments> getAllCommentsByTaskAndUserId(Long userId, Long taskId);

    Comments changeCommentByUserIdAndTaskId(Long userId, Long taskId);
}
