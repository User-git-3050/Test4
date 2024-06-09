package com.spring.project3.Controller;

import com.spring.project3.Entity.Task;
import com.spring.project3.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> list(){
        return taskService.list();
    }
    @PostMapping("/")
    public List<Task> list(){
        return taskService.list();
    }

    @PutMapping("{id}")
    public List<Task> update(@PathVariable int id){
        return taskService.list();
    }
}
