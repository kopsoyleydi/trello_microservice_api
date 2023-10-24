package com.example.task_service.controller;

import com.example.task_service.apiBodies.CommentRequest;
import com.example.task_service.apiBodies.GetTasksRequest;
import com.example.task_service.apiBodies.TaskRequest;
import com.example.task_service.dto.CommentDTO;
import com.example.task_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task/comment")
public class CommentController {

    private final CommentService commentService;

    public List<CommentDTO> getAllCommentsByTaskAndUserId(@RequestBody GetTasksRequest getTasksRequest){
        return commentService.getCommentsByUserIdAndTaskId(getTasksRequest.getUserId(), getTasksRequest.getCategoryId());
    }
    
    public void addTask(@RequestBody CommentRequest commentRequest){
        commentService.addCommentByUserIdAndTaskId(commentRequest);
    }
}
