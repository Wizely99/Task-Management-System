package com.wizely.todo.Controller;
import com.wizely.todo.Dto.User.CreateUserDTO;
import com.wizely.todo.Dto.User.ReadUserDTO;
import com.wizely.todo.Dto.User.UpdateUserDTO;
import com.wizely.todo.Entity.User;
import com.wizely.todo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO) {
        User createdUser = userService.createUser(createUserDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<ReadUserDTO>> getAllUsers() {
        List<ReadUserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadUserDTO> getUserById(@PathVariable Integer id) {
        Optional<ReadUserDTO> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody UpdateUserDTO updateUserDTO) {
        User updatedUser = userService.updateUser(id, updateUserDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
