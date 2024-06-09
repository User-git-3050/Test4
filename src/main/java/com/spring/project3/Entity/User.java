package com.spring.project3.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "user_tasks",
    joinColumns=@JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> userTasks;

    @ManyToOne()
    @JoinColumn(name="role_id")
    @JsonManagedReference
    private Role role;
}
