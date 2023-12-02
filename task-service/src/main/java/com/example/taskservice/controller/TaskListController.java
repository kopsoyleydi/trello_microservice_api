package com.example.taskservice.controller;

import com.example.taskservice.dto.response.CommonResponse;
import com.example.taskservice.bodies.TaskBody;
import com.example.taskservice.service.second.taskservice.TaskServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tasks/taskList")
@RequiredArgsConstructor
public class TaskListController {

    private final TaskServiceInter taskServiceInter;

    @PostMapping(value = "/addTaskList")
    public CommonResponse addTaskList(@RequestBody TaskBody taskBody){
        try {
            return CommonResponse
                    .builder().data(taskServiceInter.addTaskList(taskBody))
                    .message("Added Success").status(HttpStatus.CREATED).build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .status(HttpStatus.resolve(500))
                    .build();
        }
    }
}
