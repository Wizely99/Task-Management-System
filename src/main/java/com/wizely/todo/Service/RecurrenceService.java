package com.wizely.todo.Service;
import com.wizely.todo.Dto.Recurrence.CreateRecurrenceDTO;
import com.wizely.todo.Dto.Recurrence.ReadRecurrenceDTO;
import com.wizely.todo.Dto.Recurrence.UpdateRecurrenceDTO;
import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Repository.RecurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecurrenceService {

    private final RecurrenceRepository recurrenceRepository;

    public RecurrenceService(RecurrenceRepository recurrenceRepository) {
        this.recurrenceRepository = recurrenceRepository;
    }

    public Recurrence createRecurrence(CreateRecurrenceDTO createRecurrenceDTO) {
        Recurrence recurrence = createRecurrenceDTO.toEntity();
        return recurrenceRepository.save(recurrence);
    }

    public List<ReadRecurrenceDTO> getAllRecurrences() {
        List<Recurrence> recurrences = recurrenceRepository.findAll();
        return recurrences.stream().map(ReadRecurrenceDTO::fromEntity).toList();
    }

    public Optional<ReadRecurrenceDTO> getRecurrenceById(Integer recurrenceId) {
        return recurrenceRepository.findById(recurrenceId).map(ReadRecurrenceDTO::fromEntity);
    }

    public Recurrence updateRecurrence(Integer recurrenceId, UpdateRecurrenceDTO updateRecurrenceDTO) {
        Recurrence existingRecurrence = recurrenceRepository.findById(recurrenceId)
                .orElseThrow(() -> new RuntimeException("Recurrence not found"));
        return updateRecurrenceDTO.updateEntity(existingRecurrence);
    }

    public void deleteRecurrence(Integer recurrenceId) {
        recurrenceRepository.deleteById(recurrenceId);
    }
}
