package com.wizely.todo.Dto.TaskCustomDate;

import com.wizely.todo.Entity.Task;
import com.wizely.todo.Entity.TaskCustomDate;

import java.time.LocalDateTime;

public record UpdateTaskCustomDateDTO(
        LocalDateTime customDate
) {
    public TaskCustomDate updateEntity(TaskCustomDate existingTaskCustomDate) {
        existingTaskCustomDate.setCustomDate(this.customDate);
        return existingTaskCustomDate;
    }
}
