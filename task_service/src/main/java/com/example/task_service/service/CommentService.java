package com.example.task_service.service;


import com.example.task_service.apiBodies.CommentRequest;
import com.example.task_service.dto.CommentDTO;
import com.example.task_service.dto.mapper.CommentMapper;
import com.example.task_service.model.Comments;
import com.example.task_service.model.ModelImpliments.CommentIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentIMPL commentIMPL;

    private final CommentMapper commentMapper;

    public List<CommentDTO> getCommentsByUserIdAndTaskId(Long userId, Long taskId){
        return commentMapper.toDtoList(commentIMPL.getAllCommentsByTaskIdAndUserId(userId, taskId));
    }

    public CommentDTO addCommentByUserIdAndTaskId(CommentRequest commentRequest){
        Comments comments = Comments.builder().comment(commentRequest.getComment())
                .userId(commentRequest.getUserId())
                .taskId(commentRequest.getTaskId()).build();
        return commentMapper.toDto(commentIMPL.addComment(comments));
    }
}
