package com.wizely.todo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class TaskSnooze extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
@NotNull
    private LocalDateTime snoozedUntil;

    // Getters and Setters


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public LocalDateTime getSnoozedUntil() {
        return snoozedUntil;
    }

    public void setSnoozedUntil(LocalDateTime snoozedUntil) {
        this.snoozedUntil = snoozedUntil;
    }

    //No args constructor

    public TaskSnooze() {
    }

    //Constructor


    public TaskSnooze(Task task, LocalDateTime snoozedUntil) {
        this.task = task;
        this.snoozedUntil = snoozedUntil;
    }
}
