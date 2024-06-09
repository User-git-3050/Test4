package com.spring.project3.dao.request;

import com.spring.project3.Enums.PointEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {
    private Long id;

    private PointEnum point;

    @NotBlank(message = "description is required")
    @Min(value=3,message = "description should be at least 2 character")
    private String description;

    private LocalDateTime deadLine;
}
