package com.wizely.todo.Dto.TaskItem;

import com.wizely.todo.Entity.TaskItem;

public record UpdateTaskItemDTO(
        String name,
        String description,
        Boolean isCompleted
) {
    public TaskItem updateEntity(TaskItem existingTaskItem) {
        existingTaskItem.setName(this.name);
        existingTaskItem.setDescription(this.description);
        existingTaskItem.setCompleted(this.isCompleted);
        return existingTaskItem;
    }
}
