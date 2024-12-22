package com.wizely.todo.Service;
import com.wizely.todo.Dto.TaskItem.CreateTaskItemDTO;
import com.wizely.todo.Dto.TaskItem.ReadTaskItemDTO;
import com.wizely.todo.Dto.TaskItem.UpdateTaskItemDTO;
import com.wizely.todo.Entity.TaskItem;
import com.wizely.todo.Repository.TaskItemRepository;
import com.wizely.todo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskItemService {

    private final TaskItemRepository taskItemRepository;

    public TaskItemService(TaskItemRepository taskItemRepository) {
        this.taskItemRepository = taskItemRepository;
    }

    public TaskItem createTaskItem(CreateTaskItemDTO createTaskItemDTO) {
        TaskItem taskItem = createTaskItemDTO.toEntity();
        return taskItemRepository.save(taskItem);
    }

    public List<ReadTaskItemDTO> getAllTaskItems() {
        List<TaskItem> taskItems = taskItemRepository.findAll();
        return taskItems.stream().map(ReadTaskItemDTO::fromEntity).toList();
    }

    public Optional<ReadTaskItemDTO> getTaskItemById(Integer taskItemId) {
        return taskItemRepository.findById(taskItemId).map(ReadTaskItemDTO::fromEntity);
    }

    public TaskItem updateTaskItem(Integer taskItemId, UpdateTaskItemDTO updateTaskItemDTO) {
        TaskItem existingTaskItem = taskItemRepository.findById(taskItemId)
                .orElseThrow(() -> new RuntimeException("TaskItem not found"));
        return updateTaskItemDTO.updateEntity(existingTaskItem);
    }

    public void deleteTaskItem(Integer taskItemId) {
        taskItemRepository.deleteById(taskItemId);
    }
}
