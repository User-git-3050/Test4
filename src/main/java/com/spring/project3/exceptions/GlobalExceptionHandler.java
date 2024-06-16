package com.spring.project3.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();


        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));


        Map<String, Object> result = new HashMap<>();
        result.put("errors", errors);


        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("error", "Please write all arguments true");

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
