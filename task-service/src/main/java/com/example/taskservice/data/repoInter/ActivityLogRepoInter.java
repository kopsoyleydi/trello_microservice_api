package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.ActivityLog;

public interface ActivityLogRepoInter {

    ActivityLog addActivityLog(ActivityLog activityLog);

    void deleteActivityLog(ActivityLog activityLog);

    ActivityLog changeActivityLog(ActivityLog activityLog);
}
