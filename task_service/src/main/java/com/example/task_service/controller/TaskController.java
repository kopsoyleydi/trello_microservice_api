package com.example.task_service.controller;

import com.example.task_service.apiBodies.GetTasksRequest;
import com.example.task_service.apiBodies.TaskRequest;
import com.example.task_service.dto.TaskDTO;
import com.example.task_service.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getTasksByUserId/{userId}")
    public List<TaskDTO> getTasksByUserId(@RequestBody GetTasksRequest getTasksRequest){
        return taskService.getTasksByUserIdAndCategoryId(getTasksRequest);
    }

    @PostMapping(value = "/addTasksWithoutPrivateUserCategory")
    public TaskDTO addTaskWithoutPrivateUserCategory(TaskRequest taskRequest){
        return taskService.addTaskWithoutPrivateUserCategory(taskRequest);
    }


}
