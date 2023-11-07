package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.Comment;

public interface CommentRepoInter {

    Comment addComment(Comment comment);

    void deleteComment(Comment comment);

    Comment changeComment(Comment comment);
}
