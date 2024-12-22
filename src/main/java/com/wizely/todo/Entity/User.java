package com.wizely.todo.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User extends BaseEntity{

    private String username;
    private String role;
    private String password;



    // Getters and Setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//No args constructor

    public User() {
    }

    //Constructor

    public User(String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }
}
