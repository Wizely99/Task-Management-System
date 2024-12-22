package com.wizely.todo.Dto.TaskCustomDate;

import com.wizely.todo.Dto.Task.ReadTaskDTO;
import com.wizely.todo.Entity.TaskCustomDate;

import java.time.LocalDateTime;

public record ReadTaskCustomDateDTO(
        Long id,
        LocalDateTime customDate,
        ReadTaskDTO task
) {
    public static ReadTaskCustomDateDTO fromEntity(TaskCustomDate taskCustomDate) {
        return new ReadTaskCustomDateDTO(
                taskCustomDate.getId(),
                taskCustomDate.getCustomDate(),
                ReadTaskDTO.fromEntity(taskCustomDate.getTask())
        );
    }
}
