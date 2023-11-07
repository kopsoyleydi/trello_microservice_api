package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.CommentRepository;
import com.example.taskservice.data.repoInter.CommentRepoInter;
import com.example.taskservice.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentRepoInterImpl implements CommentRepoInter {

    private final CommentRepository commentRepository;
    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public Comment changeComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
