package com.example.taskservice.data.repo;

import com.example.taskservice.model.ActivityLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
