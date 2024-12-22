package com.wizely.todo.Dto.TaskCustomDate;

import com.wizely.todo.Entity.Task;
import com.wizely.todo.Entity.TaskCustomDate;

import java.time.LocalDateTime;

public record CreateTaskCustomDateDTO(
        LocalDateTime customDate,
        Long taskId
) {
    public TaskCustomDate toEntity() {
        
        Task task=new Task();
        task.setId(taskId);
        TaskCustomDate taskCustomDate = new TaskCustomDate();
        taskCustomDate.setCustomDate(this.customDate);
        taskCustomDate.setTask(task);  // Assuming Task constructor that accepts ID
        return taskCustomDate;
    }
}
