package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.ActivityLogRepository;
import com.example.taskservice.data.repoInter.ActivityLogRepoInter;
import com.example.taskservice.model.ActivityLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogRepoInterImpl implements ActivityLogRepoInter {

    private final ActivityLogRepository activityLogRepository;
    @Override
    public ActivityLog addActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public void deleteActivityLog(ActivityLog activityLog) {
        activityLogRepository.delete(activityLog);
    }

    @Override
    public ActivityLog changeActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }
}
