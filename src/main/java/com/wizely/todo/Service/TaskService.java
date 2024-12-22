package com.wizely.todo.Service;
import com.wizely.todo.Dto.Task.CreateTaskDTO;
import com.wizely.todo.Dto.Task.ReadTaskDTO;
import com.wizely.todo.Dto.Task.UpdateTaskDTO;
import com.wizely.todo.Entity.Task;
import com.wizely.todo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(CreateTaskDTO createTaskDTO) {
        Task task = createTaskDTO.toEntity();
        return taskRepository.save(task);
    }

    public List<ReadTaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(ReadTaskDTO::fromEntity).toList();
    }

    public Optional<ReadTaskDTO> getTaskById(Long taskId) {
        return taskRepository.findById(taskId).map(ReadTaskDTO::fromEntity);
    }

    public Task updateTask(Long taskId, UpdateTaskDTO updateTaskDTO) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        return updateTaskDTO.updateEntity(existingTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
