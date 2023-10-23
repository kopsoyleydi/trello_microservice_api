package com.example.task_service.service;


import com.example.task_service.apiBodies.GetTasksRequest;
import com.example.task_service.apiBodies.TaskRequest;
import com.example.task_service.dto.TaskDTO;
import com.example.task_service.dto.mapper.TaskMapper;
import com.example.task_service.model.Category;
import com.example.task_service.model.ModelImpliments.CategoryIMPL;
import com.example.task_service.model.ModelImpliments.TaskIMPL;
import com.example.task_service.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskIMPL taskIMPL;

    private final TaskMapper taskMapper;

    private final CategoryIMPL categoryIMPL;

    public List<TaskDTO> getTasksByUserIdAndCategoryId(GetTasksRequest getTasksRequest){

        return taskMapper.toDtoList(taskIMPL.getTaskByUserIdAndCategory(
                getTasksRequest.getUserId()
                 , getTasksRequest.getCategoryId()));
    }

    public TaskDTO addTaskWithoutPrivateUserCategory(TaskRequest taskRequest){
        Category category = categoryIMPL.getCategoryById(taskRequest.getCategoryId());
        Task task = Task.builder().userId(taskRequest.getUserId()).category(category)
                .comments(taskRequest.getComments())
                .description(taskRequest.getDescription())
                .header(taskRequest.getHeader())
                .createAt(Instant.now()).check(taskRequest.getCheck()).build();
        return taskMapper.toDto(taskIMPL.addTaskToPrivateUserCategoryByUserId(task));
    }
}
