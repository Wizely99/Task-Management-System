package com.wizely.todo.Dto.TaskSnooze;

import com.wizely.todo.Entity.TaskSnooze;

import java.time.LocalDateTime;

public record UpdateTaskSnoozeDTO(
        LocalDateTime snoozedUntil
) {
    public TaskSnooze updateEntity(TaskSnooze existingTaskSnooze) {
        existingTaskSnooze.setSnoozedUntil(this.snoozedUntil);
        return existingTaskSnooze;
    }
}
