package com.wizely.todo.Entity;
import com.wizely.todo.Enum.UnitMeasure;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Task extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
@NotNull
    private String name;
    @NotNull

    private String description;
    private LocalDateTime dueDate;
    private Integer status;//TODO CHANGE TO ENUM OR BOOLEAN

    @ManyToOne
    @JoinColumn(name = "recurrence_id")
    private Recurrence recurrence;



    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskItem> taskItems;

    // Getters and Setters


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }



    public List<TaskItem> getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(List<TaskItem> taskItems) {
        this.taskItems = taskItems;
    }

    //No args constructor

    public Task() {
    }

    //constructor

    public Task(User user, String name, String description, LocalDateTime dueDate, Integer status, Recurrence recurrence, List<TaskItem> taskItems) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.recurrence = recurrence;
        this.taskItems = taskItems;
    }
}


