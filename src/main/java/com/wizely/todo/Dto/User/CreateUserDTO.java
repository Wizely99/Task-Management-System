package com.wizely.todo.Dto.User;

import com.wizely.todo.Entity.User;

public record CreateUserDTO(
        String username,
        String role,
        String password
) {
    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setRole(this.role);
        user.setPassword(this.password);
        return user;
    }
}
