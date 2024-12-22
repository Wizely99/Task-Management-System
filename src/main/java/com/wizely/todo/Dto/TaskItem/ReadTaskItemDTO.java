package com.wizely.todo.Dto.TaskItem;

import com.wizely.todo.Dto.Task.ReadTaskDTO;
import com.wizely.todo.Entity.TaskItem;


public record ReadTaskItemDTO(
        Long id,
        String name,
        String description,
        Boolean isCompleted,
        ReadTaskDTO task
) {
    public static ReadTaskItemDTO fromEntity(TaskItem taskItem) {
        return new ReadTaskItemDTO(
                taskItem.getId(),
                taskItem.getName(),
                taskItem.getDescription(),
                taskItem.getCompleted(),
                ReadTaskDTO.fromEntity( taskItem.getTask())
        );
    }
}
