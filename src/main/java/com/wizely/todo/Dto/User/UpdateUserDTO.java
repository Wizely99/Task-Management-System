package com.wizely.todo.Dto.User;

import com.wizely.todo.Entity.User;

import java.time.LocalDateTime;

public record UpdateUserDTO(
        String username,
        String role
) {
    public User updateEntity(User existingUser) {
        existingUser.setUsername(this.username);
        existingUser.setRole(this.role);
        return existingUser;
    }
}

