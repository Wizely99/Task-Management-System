package com.wizely.todo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class TaskCustomDate extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
@NotNull
    private LocalDateTime customDate;

    // Getters and Setters


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public LocalDateTime getCustomDate() {
        return customDate;
    }

    public void setCustomDate(LocalDateTime customDate) {
        this.customDate = customDate;
    }

    //No args constructor

    public TaskCustomDate() {
    }
    //Constructpr

    public TaskCustomDate(Task task, LocalDateTime customDate) {
        this.task = task;
        this.customDate = customDate;
    }
}
