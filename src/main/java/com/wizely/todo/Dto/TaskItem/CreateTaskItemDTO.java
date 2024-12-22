package com.wizely.todo.Dto.TaskItem;

import com.wizely.todo.Entity.Task;
import com.wizely.todo.Entity.TaskItem;

public record CreateTaskItemDTO(
        String name,
        String description,
        Boolean isCompleted,
        Long taskId
) {
    public TaskItem toEntity() {
        Task task=new Task();
        task.setId(taskId);
        TaskItem taskItem = new TaskItem();
        taskItem.setName(this.name);
        taskItem.setDescription(this.description);
        taskItem.setCompleted(this.isCompleted);
        taskItem.setTask(task);  // Assuming Task constructor that accepts ID
        return taskItem;
    }
}
