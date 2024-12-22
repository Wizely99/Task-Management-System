package com.wizely.todo.Dto.User;

import com.wizely.todo.Entity.User;

import java.time.LocalDateTime;

public record ReadUserDTO(
        Long id,
        String username,
        String role,
        LocalDateTime createdAt
) {
    public static ReadUserDTO fromEntity(User user) {
        return new ReadUserDTO(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}
