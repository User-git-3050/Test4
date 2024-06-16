package com.spring.project3.Controller;

import com.spring.project3.Entity.Task;
import com.spring.project3.Service.TaskService;
import com.spring.project3.dao.TaskRequest;
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
    public List<Task> list() {
        return taskService.list();
    }

    @PostMapping("{adminId}/create")
    public void create(@RequestBody TaskRequest taskRequest, @PathVariable Long adminId) {
        taskService.createTask(taskRequest, adminId);
    }

    @PutMapping("{adminId}")
    public void setTasksToUser(@PathVariable Long adminId, @RequestParam Long taskId, Long userId) {
        taskService.setTasksToUser(adminId, taskId, userId);
    }

    @PutMapping("tester/{id}")
    public void update(@RequestParam Long taskId, @PathVariable Long id) {
        taskService.updateTask(taskId, id);
    }


    @PutMapping("user/{userId}")
    public void updateStatus(@PathVariable Long userId, @RequestParam String status, @RequestParam Long taskId) {
        taskService.updateStatus(userId, status, taskId);
    }

}
