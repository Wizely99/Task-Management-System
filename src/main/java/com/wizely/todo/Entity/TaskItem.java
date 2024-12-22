package com.wizely.todo.Entity;

import jakarta.persistence.*;

@Entity
public class TaskItem extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    private String name;
    private String description;
    private Boolean isCompleted;

    // Getters and Setters

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    //No-args constructor

    public TaskItem() {
    }


    //Constructor

    public TaskItem(Task task, String name, String description, Boolean isCompleted) {
        this.task = task;
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
    }
}
