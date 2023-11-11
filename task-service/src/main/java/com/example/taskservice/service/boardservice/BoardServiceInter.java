package com.example.taskservice.service.boardservice;

import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.dto.TaskListDto;

public interface BoardServiceInter {

    BoardDto addBoard(BoardDto boardDto);

    BoardDto changeBoard(BoardDto boardDto);

    BoardDto addTasksListToBoard(Long boardId, TaskListDto taskListDto);

    void deleteTasksListFromBoard(Long boardId, Long taskListId);

    void deleteBoardById(Long boardId);
}
