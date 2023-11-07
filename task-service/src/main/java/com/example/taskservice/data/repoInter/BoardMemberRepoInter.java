package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.BoardMember;
import com.example.taskservice.model.User;

import java.util.List;

public interface BoardMemberRepoInter {

    BoardMember addBoardMember(BoardMember boardMember);

    void deleteMemberFromBoard(List<User> users);

    void deleteMembersFromBoard(List<User> users);

    void deleteBoardMember(BoardMember boardMember);

    BoardMember addOnlyMembersToBoardMember(BoardMember boardMember);
}
