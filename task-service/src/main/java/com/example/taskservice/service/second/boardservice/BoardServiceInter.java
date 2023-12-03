package com.example.taskservice.service.second.boardservice;

import com.example.taskservice.bodies.AddBoard;
import com.example.taskservice.bodies.ChangeBoard;
import com.example.taskservice.dto.dtos.BoardDto;
import com.example.taskservice.dto.dtos.TaskListDto;

public interface BoardServiceInter {

    BoardDto addBoard(AddBoard addBoard);

    BoardDto changeBoard(ChangeBoard changeBoard);

    BoardDto addTasksListToBoard(Long boardId, TaskListDto taskListDto);

    void deleteTasksListFromBoard(Long boardId, Long taskListId);

    void deleteBoardById(Long boardId);
}
