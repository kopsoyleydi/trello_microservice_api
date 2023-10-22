package com.example.task_service.model.repository.repoIMPL;


import com.example.task_service.model.Task;

import java.util.List;

public interface TaskRepoInter {

    Task addTask(Task task);

    List<Task> getAllTask();

    List<Task> getTasksByUserId(Long id);

    List<Task> getTaskByUserIdAndCategory(Long id, String type);

    Task changeTaskInformationByIdAndUserId(Long taskID, Long userId);

    void deleteTaskByUserIdAndUserId(Long userId, Long taskId);

    Task addTaskToPrivateUserCategoryByUserId(Task task);
}
