package com.spring.project3.Service;

import com.spring.project3.Entity.Task;
import com.spring.project3.Entity.User;
import com.spring.project3.dao.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();

    void createUser(LoginRequest loginRequest);

    List<Task> getTasks(Long id);
}
