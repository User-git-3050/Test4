package com.spring.project3.Service;

import com.spring.project3.Entity.Task;
import com.spring.project3.dao.TaskRequest;

import java.util.List;

public interface TaskService {
    List<Task> list();

    void createTask(TaskRequest taskRequest, Long id);

    void updateTask(Long taskId, Long id);

    void updateStatus(Long userId, String status, Long taskId);

    void setTasksToUser(Long id, Long taskId, Long userId);
}
