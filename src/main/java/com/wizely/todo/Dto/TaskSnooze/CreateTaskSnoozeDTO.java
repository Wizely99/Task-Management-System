package com.wizely.todo.Dto.TaskSnooze;

import com.wizely.todo.Entity.Task;
import com.wizely.todo.Entity.TaskSnooze;

import java.time.LocalDateTime;

public record CreateTaskSnoozeDTO(
        LocalDateTime snoozedUntil,
        Long taskId
) {
    public TaskSnooze toEntity() {
        
        Task task=new Task();
        task.setId(taskId);
        TaskSnooze taskSnooze = new TaskSnooze();
        taskSnooze.setSnoozedUntil(this.snoozedUntil);
        taskSnooze.setTask(task);  // Assuming Task constructor that accepts ID
        return taskSnooze;
    }
}
