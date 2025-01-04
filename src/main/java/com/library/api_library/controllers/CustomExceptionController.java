package com.library.api_library.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.library.api_library.exceptions.models.ErrorModel;



@RestControllerAdvice
public class CustomExceptionController {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public ErrorModel resourceNotFoundException(NoResourceFoundException ex) {

        ErrorModel error = new ErrorModel();

        error.setMessage("Resource not found.");
        error.setError(ex.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(getTimestamp());
        
        return error;

    }

    private String getTimestamp() {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String date = localDateTime.format(formatter);

        return date;
    }


}
