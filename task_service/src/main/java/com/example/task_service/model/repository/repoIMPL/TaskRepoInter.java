package com.example.task_service.model.repository.repoIMPL;


import com.example.task_service.model.Task;

import java.util.List;

public interface TaskRepoInter {

    Task addTask(Task task);

    List<Task> getAllTask();


    List<Task> getTaskByUserIdAndCategory(Long id, Long categoryId);

    Task changeTaskInformation(Task task);

    void deleteTaskByUserIdAndUserId(Long userId, Long taskId);

    Task addTaskToPrivateUserCategoryByUserId(Task task);
}
