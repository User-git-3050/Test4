package com.spring.project3.Service.ServiceImpl;

import com.spring.project3.Entity.Task;
import com.spring.project3.Entity.User;
import com.spring.project3.Enums.PointEnum;
import com.spring.project3.Enums.RoleEnum;
import com.spring.project3.Enums.TaskPriority;
import com.spring.project3.Enums.TaskStatusEnum;
import com.spring.project3.Repository.TaskRepository;
import com.spring.project3.Repository.UserRepository;
import com.spring.project3.Service.TaskService;
import com.spring.project3.dao.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Task> list() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(TaskRequest taskRequest, Long id) {
        User user = userRepository.findById(id).orElse(null);

        assert user != null;
        if (user.getRole() == RoleEnum.ADMIN) {
            Task task = Task.builder().
                    point(PointEnum.valueOf(taskRequest.getPoint().toUpperCase())).
                    priority(TaskPriority.valueOf(taskRequest.getPriority().toUpperCase())).
                    description(taskRequest.getDescription()).
                    deadline(taskRequest.getDeadline()).
                    status(TaskStatusEnum.TODO).build();
            taskRepository.save(task);
        }


    }

    @Override
    public void updateTask(Long taskId, Long id) {
        Task task = taskRepository.findById(taskId).orElse(null);
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        assert task != null;

        if (user.getRole() == RoleEnum.TESTER) {
            task.setStatus(TaskStatusEnum.DONE);
        }
        taskRepository.save(task);
    }


    @Override
    public void updateStatus(Long userId, String status, Long taskId) {
        TaskStatusEnum taskStatus = TaskStatusEnum.valueOf(status.toUpperCase());
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        if (user.getRole() == RoleEnum.USER && taskStatus != TaskStatusEnum.DONE) {
            Task task = taskRepository.findById(taskId).orElse(null);
            assert task != null;
            task.setStatus(taskStatus);
            taskRepository.save(task);
        }

    }


    @Override
    public void setTasksToUser(Long id, Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        User admin = userRepository.findById(id).orElse(null);
        assert task != null;
        assert user != null;
        assert admin != null;
        if (user.getRole() == RoleEnum.USER && admin.getRole() == RoleEnum.ADMIN) {
            user.getUserTasks().add(task);
        }
        userRepository.save(user);
    }


}
