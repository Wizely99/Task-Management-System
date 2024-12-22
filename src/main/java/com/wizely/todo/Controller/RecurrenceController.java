package com.wizely.todo.Controller;
import com.wizely.todo.Dto.Recurrence.CreateRecurrenceDTO;
import com.wizely.todo.Dto.Recurrence.ReadRecurrenceDTO;
import com.wizely.todo.Dto.Recurrence.UpdateRecurrenceDTO;
import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Service.RecurrenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recurrences")
public class RecurrenceController {

    private final RecurrenceService recurrenceService;

    public RecurrenceController(RecurrenceService recurrenceService) {
        this.recurrenceService = recurrenceService;
    }

    // Create a new recurrence
    @PostMapping
    public ResponseEntity<Recurrence> createRecurrence(@RequestBody CreateRecurrenceDTO createRecurrenceDTO) {
        Recurrence createdRecurrence = recurrenceService.createRecurrence(createRecurrenceDTO);
        return new ResponseEntity<>(createdRecurrence, HttpStatus.CREATED);
    }

    // Get all recurrences
    @GetMapping
    public ResponseEntity<List<ReadRecurrenceDTO>> getAllRecurrences() {
        List<ReadRecurrenceDTO> recurrences = recurrenceService.getAllRecurrences();
        return new ResponseEntity<>(recurrences, HttpStatus.OK);
    }

    // Get recurrence by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadRecurrenceDTO> getRecurrenceById(@PathVariable Integer id) {
        Optional<ReadRecurrenceDTO> recurrence = recurrenceService.getRecurrenceById(id);
        return recurrence.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a recurrence
    @PutMapping("/{id}")
    public ResponseEntity<Recurrence> updateRecurrence(@PathVariable Integer id, @RequestBody UpdateRecurrenceDTO updateRecurrenceDTO) {
        Recurrence updatedRecurrence = recurrenceService.updateRecurrence(id, updateRecurrenceDTO);
        return ResponseEntity.ok(updatedRecurrence);
    }

    // Delete a recurrence
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurrence(@PathVariable Integer id) {
        recurrenceService.deleteRecurrence(id);
        return ResponseEntity.noContent().build();
    }
}


