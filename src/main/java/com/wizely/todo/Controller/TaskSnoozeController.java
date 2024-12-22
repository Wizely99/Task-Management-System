package com.wizely.todo.Controller;
import com.wizely.todo.Dto.TaskSnooze.CreateTaskSnoozeDTO;
import com.wizely.todo.Dto.TaskSnooze.ReadTaskSnoozeDTO;
import com.wizely.todo.Dto.TaskSnooze.UpdateTaskSnoozeDTO;
import com.wizely.todo.Entity.TaskSnooze;
import com.wizely.todo.Service.TaskSnoozeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-snoozes")
public class TaskSnoozeController {

    private final TaskSnoozeService taskSnoozeService;

    public TaskSnoozeController(TaskSnoozeService taskSnoozeService) {
        this.taskSnoozeService = taskSnoozeService;
    }

    // Create a new task snooze
    @PostMapping
    public ResponseEntity<TaskSnooze> createTaskSnooze(@RequestBody CreateTaskSnoozeDTO createTaskSnoozeDTO) {
        TaskSnooze createdTaskSnooze = taskSnoozeService.createTaskSnooze(createTaskSnoozeDTO);
        return new ResponseEntity<>(createdTaskSnooze, HttpStatus.CREATED);
    }

    // Get all task snoozes
    @GetMapping
    public ResponseEntity<List<ReadTaskSnoozeDTO>> getAllTaskSnoozes() {
        List<ReadTaskSnoozeDTO> taskSnoozes = taskSnoozeService.getAllTaskSnoozes();
        return new ResponseEntity<>(taskSnoozes, HttpStatus.OK);
    }

    // Get task snooze by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadTaskSnoozeDTO> getTaskSnoozeById(@PathVariable Integer id) {
        Optional<ReadTaskSnoozeDTO> taskSnooze = taskSnoozeService.getTaskSnoozeById(id);
        return taskSnooze.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a task snooze
    @PutMapping("/{id}")
    public ResponseEntity<TaskSnooze> updateTaskSnooze(@PathVariable Integer id, @RequestBody UpdateTaskSnoozeDTO updateTaskSnoozeDTO) {
        TaskSnooze updatedTaskSnooze = taskSnoozeService.updateTaskSnooze(id, updateTaskSnoozeDTO);
        return ResponseEntity.ok(updatedTaskSnooze);
    }

    // Delete a task snooze
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskSnooze(@PathVariable Integer id) {
        taskSnoozeService.deleteTaskSnooze(id);
        return ResponseEntity.noContent().build();
    }
}
