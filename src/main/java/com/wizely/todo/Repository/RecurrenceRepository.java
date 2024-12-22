package com.wizely.todo.Repository;

import com.wizely.todo.Entity.Recurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecurrenceRepository extends JpaRepository<Recurrence, Integer> {
}
