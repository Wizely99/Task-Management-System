package com.wizely.todo.Controller;
import com.wizely.todo.Dto.TaskCustomDate.CreateTaskCustomDateDTO;
import com.wizely.todo.Dto.TaskCustomDate.ReadTaskCustomDateDTO;
import com.wizely.todo.Dto.TaskCustomDate.UpdateTaskCustomDateDTO;
import com.wizely.todo.Entity.TaskCustomDate;
import com.wizely.todo.Service.TaskCustomDateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-custom-dates")
public class TaskCustomDateController {


    private final TaskCustomDateService taskCustomDateService;

    public TaskCustomDateController(TaskCustomDateService taskCustomDateService) {
        this.taskCustomDateService = taskCustomDateService;
    }

    // Create a new task custom date
    @PostMapping
    public ResponseEntity<TaskCustomDate> createTaskCustomDate(@RequestBody CreateTaskCustomDateDTO createTaskCustomDateDTO) {
        TaskCustomDate createdTaskCustomDate = taskCustomDateService.createTaskCustomDate(createTaskCustomDateDTO);
        return new ResponseEntity<>(createdTaskCustomDate, HttpStatus.CREATED);
    }

    // Get all task custom dates
    @GetMapping
    public ResponseEntity<List<ReadTaskCustomDateDTO>> getAllTaskCustomDates() {
        List<ReadTaskCustomDateDTO> taskCustomDates = taskCustomDateService.getAllTaskCustomDates();
        return new ResponseEntity<>(taskCustomDates, HttpStatus.OK);
    }

    // Get task custom date by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadTaskCustomDateDTO> getTaskCustomDateById(@PathVariable Integer id) {
        Optional<ReadTaskCustomDateDTO> taskCustomDate = taskCustomDateService.getTaskCustomDateById(id);
        return taskCustomDate.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a task custom date
    @PutMapping("/{id}")
    public ResponseEntity<TaskCustomDate> updateTaskCustomDate(@PathVariable Integer id, @RequestBody UpdateTaskCustomDateDTO updateTaskCustomDateDTO) {
        TaskCustomDate updatedTaskCustomDate = taskCustomDateService.updateTaskCustomDate(id, updateTaskCustomDateDTO);
        return ResponseEntity.ok(updatedTaskCustomDate);
    }

    // Delete a task custom date
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskCustomDate(@PathVariable Integer id) {
        taskCustomDateService.deleteTaskCustomDate(id);
        return ResponseEntity.noContent().build();
    }
}
