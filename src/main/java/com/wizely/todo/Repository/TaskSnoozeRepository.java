package com.wizely.todo.Repository;

import com.wizely.todo.Entity.TaskSnooze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSnoozeRepository extends JpaRepository<TaskSnooze, Integer> {
}
