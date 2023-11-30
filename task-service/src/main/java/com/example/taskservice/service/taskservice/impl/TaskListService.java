package com.example.taskservice.service.taskservice.impl;

import com.example.taskservice.data.repoInter.BoardRepoInter;
import com.example.taskservice.data.repoInter.TaskListRepoInter;
import com.example.taskservice.dto.TaskListDto;
import com.example.taskservice.dto.mapperDto.BoardMapper;
import com.example.taskservice.dto.mapperDto.TaskListMapper;
import com.example.taskservice.dto.response.TaskBody;
import com.example.taskservice.service.taskservice.TaskServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@RequiredArgsConstructor
public class TaskListService implements TaskServiceInter {
    private final TaskListRepoInter taskListRepoInter;
    private final TaskListMapper taskListMapper;
    private final BoardRepoInter boardRepoInter;
    private final BoardMapper boardMapper;

    @Override
    public TaskListDto addTaskList(TaskBody taskBody){
        TaskListDto taskListDto = new TaskListDto();
        taskListDto.setName(taskBody.getName());
        taskListDto.setBoard(boardMapper.toDto(boardRepoInter.getBoardById(taskBody.getId())));
        taskListDto.setCreated_at(Instant.now());
        taskListDto.setPosition("NEXT");
        return taskListMapper.toDto(
                taskListRepoInter.addTasksList(
                        taskListMapper.toModel(taskListDto)));
    }
}
