package com.wizely.todo.Dto.Recurrence;

import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Enum.UnitMeasure;

public record ReadRecurrenceDTO(
        Long id,
        Integer frequency,
        UnitMeasure unitInterval,
        Boolean skipWeekends
) {
    public static ReadRecurrenceDTO fromEntity(Recurrence recurrence) {
        return new ReadRecurrenceDTO(
                recurrence.getId(),
                recurrence.getFrequency(),
                recurrence.getUnitInterval(),
                recurrence.getSkipWeekends()
        );
    }
}
