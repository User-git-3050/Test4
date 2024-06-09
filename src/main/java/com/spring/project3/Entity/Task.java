package com.spring.project3.Entity;

import com.spring.project3.Enums.PointEnum;
import com.spring.project3.Enums.TaskPriority;
import com.spring.project3.Enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;



@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private PointEnum point;

    private TaskPriority taskPriority;

    private String description;

    private LocalDateTime deadline;

    private TaskStatusEnum taskStatus;


    @ManyToMany(mappedBy = "userTasks")
    private List<User> taskUsers;

}
