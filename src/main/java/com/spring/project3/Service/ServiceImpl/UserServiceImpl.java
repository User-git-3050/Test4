package com.spring.project3.Service.ServiceImpl;

import com.spring.project3.Entity.Task;
import com.spring.project3.Entity.User;
import com.spring.project3.Repository.UserRepository;
import com.spring.project3.Service.UserService;
import com.spring.project3.dao.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(LoginRequest loginRequest) {
        User user = User.builder().
                name(loginRequest.getUsername()).
                role(loginRequest.getRole()).
                build();
        userRepository.save(user);
    }

    @Override
    public List<Task> getTasks(Long id) {
        User user = userRepository.findById(id).orElse(null);

        assert user != null;

        return user.getUserTasks();
    }

    ;
}
