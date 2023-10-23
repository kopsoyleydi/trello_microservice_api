package com.example.task_service.service;


import com.example.task_service.dto.mapper.CommentMapper;
import com.example.task_service.model.ModelImpliments.CommentIMPL;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentIMPL commentIMPL;

    private final CommentMapper commentMapper;
}
