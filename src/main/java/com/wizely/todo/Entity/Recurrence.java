package com.wizely.todo.Entity;

import com.wizely.todo.Enum.UnitMeasure;
import jakarta.persistence.*;

@Entity
public class Recurrence extends BaseEntity {

    private Integer frequency;

    @Enumerated(EnumType.STRING)
    private UnitMeasure unitInterval;

    private Boolean skipWeekends;

    // Getters and Setters


    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public UnitMeasure getUnitInterval() {
        return unitInterval;
    }

    public void setUnitInterval(UnitMeasure unitInterval) {
        this.unitInterval = unitInterval;
    }

    public Boolean getSkipWeekends() {
        return skipWeekends;
    }

    public void setSkipWeekends(Boolean skipWeekends) {
        this.skipWeekends = skipWeekends;
    }

    //No args constructor

    public Recurrence() {
    }

    //COnstructor

    public Recurrence(Integer frequency, UnitMeasure unitInterval, Boolean skipWeekends) {
        this.frequency = frequency;
        this.unitInterval = unitInterval;
        this.skipWeekends = skipWeekends;
    }
}
