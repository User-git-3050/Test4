package com.spring.project3.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Enumerated(EnumType.STRING)
    private PointEnum point;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private String description;


    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;


    @ManyToMany(mappedBy = "userTasks")
    @JsonBackReference
    private List<User> taskUsers;

}
