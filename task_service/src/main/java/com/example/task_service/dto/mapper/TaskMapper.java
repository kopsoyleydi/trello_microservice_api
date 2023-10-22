package com.example.task_service.dto.mapper;


import com.example.task_service.dto.TaskDTO;
import com.example.task_service.model.Task;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDto(Task privateUserCategory);

    Task toModel(TaskDTO categoryDTO);

    List<TaskDTO> toDtoList(List<Task> list);

    List<Task> toModelList(List<TaskDTO> list);

}
