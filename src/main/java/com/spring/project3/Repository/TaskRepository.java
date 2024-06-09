package com.spring.project3.Repository;

import com.spring.project3.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByDeadlineAfter(LocalDateTime deadline);
    List<Task> findAllByDeadlineEquals(LocalDateTime deadline);
    List<Task> findAllByDeadlineBetween(LocalDateTime startAt, LocalDateTime endAt);
}
