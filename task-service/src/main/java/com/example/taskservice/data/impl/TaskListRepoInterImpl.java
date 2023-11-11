package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.TaskListRepository;
import com.example.taskservice.data.repoInter.TaskListRepoInter;
import com.example.taskservice.model.TaskList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskListRepoInterImpl implements TaskListRepoInter {

    private final TaskListRepository taskListRepository;
    @Override
    public TaskList addTasksList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @Override
    public void deleteTasksList(TaskList taskList) {
        taskListRepository.delete(taskList);
    }

    @Override
    public TaskList changeTasksList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @Override
    public TaskList getTaskListById(Long taskListId) {
        return taskListRepository.findAllById(taskListId);
    }
}
