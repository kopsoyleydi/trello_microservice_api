package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.BoardMember;
import com.example.taskservice.model.User;

import java.util.List;

public interface BoardMemberRepoInter {

    BoardMember addBoardMember(BoardMember boardMember);

    void deleteMemberFromBoard(BoardMember boardMember);

    void deleteMembersFromBoard(BoardMember boardMember);


    BoardMember addOnlyMembersToBoardMember(BoardMember boardMember);

    BoardMember changeBoardMember(BoardMember boardMember);
}
