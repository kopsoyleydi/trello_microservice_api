package com.example.taskservice.service.second.taskservice;

import com.example.taskservice.dto.TaskListDto;
import com.example.taskservice.bodies.TaskBody;

public interface TaskServiceInter {

    public TaskListDto addTaskList(TaskBody taskBody);

}
