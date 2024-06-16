package com.spring.project3.dao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {
    private String point;
    private String priority;

    @NotBlank(message = "description is required")
    @Min(value = 3, message = "description should be at least 2 character")
    private String description;

    private LocalDateTime deadline;
}
