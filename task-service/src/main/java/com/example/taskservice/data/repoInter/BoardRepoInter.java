package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.Board;
public interface BoardRepoInter {

    Board addBoard(Board board);

    void deleteBoardById(Long board_id);

    Board changeBoard(Board board);

    Board addTasksListToBoard(Board board);

    void deleteTasksListFromBoard(Board board);

}
