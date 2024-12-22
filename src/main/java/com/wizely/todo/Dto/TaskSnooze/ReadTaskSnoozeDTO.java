package com.wizely.todo.Dto.TaskSnooze;

import com.wizely.todo.Dto.Task.ReadTaskDTO;
import com.wizely.todo.Entity.TaskSnooze;

import java.time.LocalDateTime;

public record ReadTaskSnoozeDTO(
        Long id,
        LocalDateTime snoozedUntil,
        ReadTaskDTO task
) {
    public static ReadTaskSnoozeDTO fromEntity(TaskSnooze taskSnooze) {
        return new ReadTaskSnoozeDTO(
                taskSnooze.getId(),
                taskSnooze.getSnoozedUntil(),
                ReadTaskDTO.fromEntity( taskSnooze.getTask())
        );
    }
}
