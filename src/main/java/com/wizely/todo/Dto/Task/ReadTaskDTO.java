package com.wizely.todo.Dto.Task;

import com.wizely.todo.Dto.Recurrence.ReadRecurrenceDTO;
import com.wizely.todo.Dto.User.ReadUserDTO;
import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Entity.Task;

import java.time.LocalDateTime;
public record ReadTaskDTO(
        Long id,
        String name,
        String description,
        LocalDateTime dueDate,
        Integer status,
        ReadUserDTO user,
        ReadRecurrenceDTO recurrence,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ReadTaskDTO fromEntity(Task task) {
        return new ReadTaskDTO(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                ReadUserDTO.fromEntity(task.getUser()),  // Assuming User entity has getId()
                ReadRecurrenceDTO.fromEntity(task.getRecurrence()),  // Assuming Recurrence entity has getId()
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
