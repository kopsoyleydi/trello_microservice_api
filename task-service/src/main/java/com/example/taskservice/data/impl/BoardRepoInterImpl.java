package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.BoardRepository;
import com.example.taskservice.data.repoInter.BoardRepoInter;
import com.example.taskservice.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardRepoInterImpl implements BoardRepoInter {


    private final BoardRepository boardRepository;

    @Override
    public Board addBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteBoardById(Long board_id) {
        boardRepository.deleteById(board_id);
    }

    @Override
    public Board changeBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Board addTasksListToBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteTasksListFromBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public Board getBoardById(Long id) {
        return boardRepository.findAllById(id);
    }
}
