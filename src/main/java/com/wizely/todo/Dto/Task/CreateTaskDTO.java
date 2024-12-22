package com.wizely.todo.Dto.Task;

import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Entity.Task;
import com.wizely.todo.Entity.User;

import java.time.LocalDateTime;
public record CreateTaskDTO(
        String name,
        String description,
        LocalDateTime dueDate,
        Integer status,
        Long userId,
        Long recurrenceId
) {
    public Task toEntity() {
        User user=new User();
        user.setId(userId);
        Task task = new Task();
        task.setName(this.name);
        task.setDescription(this.description);
        task.setDueDate(this.dueDate);
        task.setStatus(this.status);
        task.setUser(user);

        if(recurrenceId!=null){

            Recurrence recurrence=new Recurrence();
            recurrence.setId(recurrenceId);
        task.setRecurrence(recurrence);
        }

        return task;
    }
}
