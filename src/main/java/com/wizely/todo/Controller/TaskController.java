package com.wizely.todo.Controller;

import com.wizely.todo.Dto.Task.CreateTaskDTO;
import com.wizely.todo.Dto.Task.ReadTaskDTO;
import com.wizely.todo.Dto.Task.UpdateTaskDTO;
import com.wizely.todo.Entity.Task;
import com.wizely.todo.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        Task createdTask = taskService.createTask(createTaskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<List<ReadTaskDTO>> getAllTasks() {
        List<ReadTaskDTO> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadTaskDTO> getTaskById(@PathVariable Long id) {
        Optional<ReadTaskDTO> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody UpdateTaskDTO updateTaskDTO) {
        Task updatedTask = taskService.updateTask(id, updateTaskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
