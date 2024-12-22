package com.wizely.todo.Controller;
import com.wizely.todo.Dto.TaskItem.CreateTaskItemDTO;
import com.wizely.todo.Dto.TaskItem.ReadTaskItemDTO;
import com.wizely.todo.Dto.TaskItem.UpdateTaskItemDTO;
import com.wizely.todo.Entity.TaskItem;
import com.wizely.todo.Service.TaskItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-items")
public class TaskItemController {

    private final TaskItemService taskItemService;

    public TaskItemController(TaskItemService taskItemService) {
        this.taskItemService = taskItemService;
    }

    // Create a new task item
    @PostMapping
    public ResponseEntity<TaskItem> createTaskItem(@RequestBody CreateTaskItemDTO createTaskItemDTO) {
        TaskItem createdTaskItem = taskItemService.createTaskItem(createTaskItemDTO);
        return new ResponseEntity<>(createdTaskItem, HttpStatus.CREATED);
    }

    // Get all task items
    @GetMapping
    public ResponseEntity<List<ReadTaskItemDTO>> getAllTaskItems() {
        List<ReadTaskItemDTO> taskItems = taskItemService.getAllTaskItems();
        return new ResponseEntity<>(taskItems, HttpStatus.OK);
    }

    // Get task item by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadTaskItemDTO> getTaskItemById(@PathVariable Integer id) {
        Optional<ReadTaskItemDTO> taskItem = taskItemService.getTaskItemById(id);
        return taskItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a task item
    @PutMapping("/{id}")
    public ResponseEntity<TaskItem> updateTaskItem(@PathVariable Integer id, @RequestBody UpdateTaskItemDTO updateTaskItemDTO) {
        TaskItem updatedTaskItem = taskItemService.updateTaskItem(id, updateTaskItemDTO);
        return ResponseEntity.ok(updatedTaskItem);
    }

    // Delete a task item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskItem(@PathVariable Integer id) {
        taskItemService.deleteTaskItem(id);
        return ResponseEntity.noContent().build();
    }
}
