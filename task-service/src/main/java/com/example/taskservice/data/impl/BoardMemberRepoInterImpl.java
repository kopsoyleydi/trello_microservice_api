package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.BoardMemberRepository;
import com.example.taskservice.data.repoInter.BoardMemberRepoInter;
import com.example.taskservice.model.BoardMember;
import com.example.taskservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardMemberRepoInterImpl implements BoardMemberRepoInter {

    private final BoardMemberRepository boardMemberRepository;
    @Override
    public BoardMember addBoardMember(BoardMember boardMember) {
        return boardMemberRepository.save(boardMember);
    }

    @Override
    public void deleteMemberFromBoard(List<User> users) {
        boardMemberRepository.deleteByUsers(users);
    }

    @Override
    public void deleteMembersFromBoard(List<User> users) {
        boardMemberRepository.deleteByUsers(users);
    }

    @Override
    public void deleteBoardMember(BoardMember boardMember) {
        boardMemberRepository.delete(boardMember);
    }

    @Override
    public BoardMember addOnlyMembersToBoardMember(BoardMember boardMember) {
        return boardMemberRepository.save(boardMember);
    }
}
