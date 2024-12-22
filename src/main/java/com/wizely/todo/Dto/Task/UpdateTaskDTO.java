package com.wizely.todo.Dto.Task;

import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Entity.Task;

import java.time.LocalDateTime;
public record UpdateTaskDTO(
        String name,
        String description,
        LocalDateTime dueDate,
        Integer status,
        Long recurrenceId
) {
    public Task updateEntity(Task existingTask) {
        Recurrence recurrence=new Recurrence();
        recurrence.setId(recurrenceId);
        existingTask.setName(this.name);
        existingTask.setDescription(this.description);
        existingTask.setDueDate(this.dueDate);
        existingTask.setStatus(this.status);
        existingTask.setRecurrence(recurrence);
        return existingTask;
    }
}
