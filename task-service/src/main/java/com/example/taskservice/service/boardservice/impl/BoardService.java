package com.example.taskservice.service.boardservice.impl;

import com.example.taskservice.data.repoInter.BoardRepoInter;
import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.dto.TaskListDto;
import com.example.taskservice.dto.mapperDto.BoardMapper;
import com.example.taskservice.dto.mapperDto.TaskListMapper;
import com.example.taskservice.model.Board;
import com.example.taskservice.service.boardservice.BoardServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BoardService implements BoardServiceInter {

    private final BoardRepoInter boardRepoInter;

    private final BoardMapper boardMapper;

    private final TaskListMapper taskListMapper;

    @Override
    public BoardDto addBoard(BoardDto boardDto) {
        boardDto.setCreated_at(Instant.now());
        return boardMapper
                .toDto(boardRepoInter
                        .addBoard(boardMapper.toModel(boardDto)));
    }

    @Override
    public BoardDto changeBoard(BoardDto boardDto) {
        return boardMapper
                .toDto(boardRepoInter
                        .changeBoard(boardMapper.toModel(boardDto)));
    }

    @Override
    public BoardDto addTasksListToBoard(Long boardId, TaskListDto taskListDto) {
        Board board = boardRepoInter.getBoardById(boardId);
        board.getLists().add(taskListMapper.toModel(taskListDto));
        return boardMapper
                .toDto(boardRepoInter
                        .addTasksListToBoard(board));
    }

    @Override
    public void deleteTasksListFromBoard(Long boardId, Long taskListId) {
        Board board = boardRepoInter.getBoardById(boardId);
        board.getLists().remove(taskListId.intValue());
        boardRepoInter.deleteTasksListFromBoard(board);
    }

    @Override
    public void deleteBoardById(Long boardId) {
        boardRepoInter.deleteBoardById(boardId);
    }


}
