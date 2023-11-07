package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.TaskList;

public interface TaskListRepoInter {

    TaskList addTasksList(TaskList taskList);

    void deleteTasksList(TaskList taskList);

    TaskList changeTasksList(TaskList taskList);
}
