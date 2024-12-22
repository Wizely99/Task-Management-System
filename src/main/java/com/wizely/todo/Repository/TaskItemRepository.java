package com.wizely.todo.Repository;

import com.wizely.todo.Entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItem, Integer> {
}
