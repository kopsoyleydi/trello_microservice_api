package com.example.taskservice.data.repo;

import com.example.taskservice.model.BoardMember;
import com.example.taskservice.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface BoardMemberRepository extends JpaRepository<BoardMember, Long> {

    void deleteByUsers(List<User> users);

}
