package com.example.task_service.model.ModelImpliments;

import com.example.task_service.model.Task;
import com.example.task_service.model.repository.TaskRepository;
import com.example.task_service.model.repository.repoIMPL.TaskRepoInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskIMPL implements TaskRepoInter {

    private final TaskRepository taskRepository;
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }


    @Override
    public List<Task> getTaskByUserIdAndCategory(Long id, Long categoryId) {
        return taskRepository.getTasksByUserIdAndCategoryId(id, categoryId);
    }

    @Override
    public Task changeTaskInformation(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskByUserIdAndUserId(Long userId, Long taskId) {
        taskRepository.deleteByUserIdAndCategoryId(userId, taskId);
    }

    @Override
    public Task addTaskToPrivateUserCategoryByUserId(Task task) {
        return taskRepository.save(task);
    }
}
