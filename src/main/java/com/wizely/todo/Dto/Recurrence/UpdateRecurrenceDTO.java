package com.wizely.todo.Dto.Recurrence;

import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Enum.UnitMeasure;

public record UpdateRecurrenceDTO(
        Integer frequency,
        UnitMeasure unitInterval,
        Boolean skipWeekends
) {
    public Recurrence updateEntity(Recurrence existingRecurrence) {
        existingRecurrence.setFrequency(this.frequency);
        existingRecurrence.setUnitInterval(this.unitInterval);
        existingRecurrence.setSkipWeekends(this.skipWeekends);
        return existingRecurrence;
    }
}

