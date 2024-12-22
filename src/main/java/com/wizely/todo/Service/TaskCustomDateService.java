package com.wizely.todo.Service;
import com.wizely.todo.Dto.TaskCustomDate.CreateTaskCustomDateDTO;
import com.wizely.todo.Dto.TaskCustomDate.ReadTaskCustomDateDTO;
import com.wizely.todo.Dto.TaskCustomDate.UpdateTaskCustomDateDTO;
import com.wizely.todo.Entity.TaskCustomDate;
import com.wizely.todo.Repository.TaskCustomDateRepository;
import com.wizely.todo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCustomDateService {

    private final TaskCustomDateRepository taskCustomDateRepository;


    public TaskCustomDateService(TaskCustomDateRepository taskCustomDateRepository) {
        this.taskCustomDateRepository = taskCustomDateRepository;
    }

    public TaskCustomDate createTaskCustomDate(CreateTaskCustomDateDTO createTaskCustomDateDTO) {
        TaskCustomDate taskCustomDate = createTaskCustomDateDTO.toEntity();
        return taskCustomDateRepository.save(taskCustomDate);
    }

    public List<ReadTaskCustomDateDTO> getAllTaskCustomDates() {
        List<TaskCustomDate> taskCustomDates = taskCustomDateRepository.findAll();
        return taskCustomDates.stream().map(ReadTaskCustomDateDTO::fromEntity).toList();
    }

    public Optional<ReadTaskCustomDateDTO> getTaskCustomDateById(Integer taskCustomDateId) {
        return taskCustomDateRepository.findById(taskCustomDateId).map(ReadTaskCustomDateDTO::fromEntity);
    }

    public TaskCustomDate updateTaskCustomDate(Integer taskCustomDateId, UpdateTaskCustomDateDTO updateTaskCustomDateDTO) {
        TaskCustomDate existingTaskCustomDate = taskCustomDateRepository.findById(taskCustomDateId)
                .orElseThrow(() -> new RuntimeException("TaskCustomDate not found"));
        return updateTaskCustomDateDTO.updateEntity(existingTaskCustomDate);
    }

    public void deleteTaskCustomDate(Integer taskCustomDateId) {
        taskCustomDateRepository.deleteById(taskCustomDateId);
    }
}
