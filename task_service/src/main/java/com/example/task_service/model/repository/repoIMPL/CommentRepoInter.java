package com.example.task_service.model.repository.repoIMPL;

import com.example.task_service.model.Comments;

import java.util.List;

public interface CommentRepoInter {

    Comments addComment(Comments comments);

    List<Comments> getAllCommentsByTaskIdAndUserId(Long userId, Long taskId);

    Comments changeCommentByUserIdAndTaskId(Long userId, Long taskId, String comment);
}
