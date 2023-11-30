package com.example.taskservice.service.taskservice;

import com.example.taskservice.dto.TaskListDto;
import com.example.taskservice.dto.response.TaskBody;

public interface TaskServiceInter {

    public TaskListDto addTaskList(TaskBody taskBody);

}
