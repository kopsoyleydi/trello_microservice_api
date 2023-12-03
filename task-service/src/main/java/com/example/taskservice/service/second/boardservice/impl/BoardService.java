package com.example.taskservice.service.second.boardservice.impl;

import com.example.taskservice.bodies.AddBoard;
import com.example.taskservice.bodies.ChangeBoard;
import com.example.taskservice.data.repoInter.BoardRepoInter;
import com.example.taskservice.dto.dtos.BoardDto;
import com.example.taskservice.dto.dtos.TaskListDto;
import com.example.taskservice.dto.mapperDto.BoardMapper;
import com.example.taskservice.model.Board;
import com.example.taskservice.service.second.boardservice.BoardServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BoardService implements BoardServiceInter {

    private final BoardRepoInter boardRepoInter;

    private final BoardMapper boardMapper;


    @Override
    public BoardDto addBoard(AddBoard addBoard) {
        Board board = new Board();
        board.setCreated_at(Instant.now());
        board.setName(addBoard.getName());
        return boardMapper.toDto(boardRepoInter.addBoard(board));
    }

    @Override
    public BoardDto changeBoard(ChangeBoard changeBoard) {
        BoardDto boardDto = new BoardDto();
        return boardMapper
                .toDto(boardRepoInter
                        .changeBoard(boardMapper.toModel(boardDto)));
    }

    @Override
    public BoardDto addTasksListToBoard(Long boardId, TaskListDto taskListDto) {
        Board board = boardRepoInter.getBoardById(boardId);
        return boardMapper
                .toDto(boardRepoInter
                        .addTasksListToBoard(board));
    }

    @Override
    public void deleteTasksListFromBoard(Long boardId, Long taskListId) {
        Board board = boardRepoInter.getBoardById(boardId);
        boardRepoInter.deleteTasksListFromBoard(board);
    }

    @Override
    public void deleteBoardById(Long boardId) {
        boardRepoInter.deleteBoardById(boardId);
    }


}
