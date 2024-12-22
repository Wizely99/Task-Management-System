package com.wizely.todo.Dto.Recurrence;

import com.wizely.todo.Entity.Recurrence;
import com.wizely.todo.Enum.UnitMeasure;

public record CreateRecurrenceDTO(
        Integer frequency,
        UnitMeasure unitInterval,
        Boolean skipWeekends
) {
    public Recurrence toEntity() {
        Recurrence recurrence = new Recurrence();
        recurrence.setFrequency(this.frequency);
        recurrence.setUnitInterval(this.unitInterval);
        recurrence.setSkipWeekends(this.skipWeekends);
        return recurrence;
    }
}
