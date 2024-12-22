package com.wizely.todo.Service;
import com.wizely.todo.Dto.TaskSnooze.CreateTaskSnoozeDTO;
import com.wizely.todo.Dto.TaskSnooze.ReadTaskSnoozeDTO;
import com.wizely.todo.Dto.TaskSnooze.UpdateTaskSnoozeDTO;
import com.wizely.todo.Entity.TaskSnooze;
import com.wizely.todo.Repository.TaskRepository;
import com.wizely.todo.Repository.TaskSnoozeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskSnoozeService {

    private final TaskSnoozeRepository taskSnoozeRepository;

    public TaskSnoozeService(TaskSnoozeRepository taskSnoozeRepository) {
        this.taskSnoozeRepository = taskSnoozeRepository;
    }

    public TaskSnooze createTaskSnooze(CreateTaskSnoozeDTO createTaskSnoozeDTO) {
        TaskSnooze taskSnooze = createTaskSnoozeDTO.toEntity();
        return taskSnoozeRepository.save(taskSnooze);
    }

    public List<ReadTaskSnoozeDTO> getAllTaskSnoozes() {
        List<TaskSnooze> taskSnoozes = taskSnoozeRepository.findAll();
        return taskSnoozes.stream().map(ReadTaskSnoozeDTO::fromEntity).toList();
    }

    public Optional<ReadTaskSnoozeDTO> getTaskSnoozeById(Integer taskSnoozeId) {
        return taskSnoozeRepository.findById(taskSnoozeId).map(ReadTaskSnoozeDTO::fromEntity);
    }

    public TaskSnooze updateTaskSnooze(Integer taskSnoozeId, UpdateTaskSnoozeDTO updateTaskSnoozeDTO) {
        TaskSnooze existingTaskSnooze = taskSnoozeRepository.findById(taskSnoozeId)
                .orElseThrow(() -> new RuntimeException("TaskSnooze not found"));
        return updateTaskSnoozeDTO.updateEntity(existingTaskSnooze);
    }

    public void deleteTaskSnooze(Integer taskSnoozeId) {
        taskSnoozeRepository.deleteById(taskSnoozeId);
    }
}
