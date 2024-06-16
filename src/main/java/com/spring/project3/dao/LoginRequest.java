package com.spring.project3.dao;

import com.spring.project3.Enums.RoleEnum;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private RoleEnum role;
}
