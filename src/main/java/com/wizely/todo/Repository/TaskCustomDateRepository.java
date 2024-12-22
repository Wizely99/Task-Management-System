package com.wizely.todo.Repository;
import com.wizely.todo.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCustomDateRepository extends JpaRepository<TaskCustomDate, Integer> {
}


