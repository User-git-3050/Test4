package com.spring.project3.Service.ServiceImpl;

import com.spring.project3.Entity.Task;
import com.spring.project3.Repository.TaskRepository;
import com.spring.project3.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> list(){
        return taskRepository.findAll();
    }


}
