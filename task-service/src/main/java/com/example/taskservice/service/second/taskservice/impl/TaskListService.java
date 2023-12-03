package com.example.taskservice.service.second.taskservice.impl;

import com.example.taskservice.data.repoInter.BoardRepoInter;
import com.example.taskservice.data.repoInter.TaskListRepoInter;
import com.example.taskservice.dto.dtos.BoardDto;
import com.example.taskservice.dto.dtos.TaskListDto;

import com.example.taskservice.bodies.TaskBody;
import com.example.taskservice.model.Board;
import com.example.taskservice.model.TaskList;
import com.example.taskservice.service.second.taskservice.TaskServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;




@Service
@RequiredArgsConstructor
public class TaskListService implements TaskServiceInter {
    private final TaskListRepoInter taskListRepoInter;

    private final BoardRepoInter boardRepoInter;


    @Override
    public TaskListDto addTaskList(TaskBody taskBody){
        Board board = boardRepoInter.getBoardById(taskBody.getBoardId());
        TaskList taskList = new TaskList();
        taskList.setName(taskBody.getName());
        taskList.setPosition("NEXT");
        taskList.setBoard(board);
        taskList.setCreated_at(Instant.now());
        TaskList taskListNew = taskListRepoInter.addTasksList(taskList);
        Board boardNew = boardRepoInter.addTasksListToBoard(board);
        BoardDto boardDto = new BoardDto();
        boardDto.setId(boardNew.getId());
        boardDto.setName(boardNew.getName());
        boardDto.setCreated_at(boardNew.getCreated_at());
        TaskListDto taskListDto = new TaskListDto();
        taskListDto.setPosition(taskListNew.getPosition());
        taskListDto.setId(taskListNew.getId());
        taskListDto.setCreated_at(taskListNew.getCreated_at());
        taskListDto.setBoard(boardDto);
        taskListDto.setName(taskListNew.getName());
        return taskListDto;
    }
}
