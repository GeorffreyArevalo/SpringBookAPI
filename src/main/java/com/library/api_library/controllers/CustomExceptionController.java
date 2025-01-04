package com.library.api_library.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;



@RestControllerAdvice
public class CustomExceptionController {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public Map<String, Object> resourceNotFoundException(NoResourceFoundException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("message", "Resource not found.");
        error.put("error", ex.getMessage());
        error.put("statusCode", HttpStatus.NOT_FOUND.value());
        error.put("timestamp", getTimestamp());
        
        return error;

    }

    private String getTimestamp() {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String date = localDateTime.format(formatter);

        return date;
    }


}
