package com.library.api_library.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.library.api_library.exceptions.BodyNotValidException;
import com.library.api_library.exceptions.DataNotFoundException;
import com.library.api_library.exceptions.models.ErrorModel;



@RestControllerAdvice
public class CustomExceptionController {

    @ExceptionHandler({NoResourceFoundException.class, DataNotFoundException.class})
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public ErrorModel resourceNotFoundException(Exception ex) {

        ErrorModel error = new ErrorModel();
        error.setMessage("Resource or Data not found.");
        error.setError(ex.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(getTimestamp());
        
        return error;

    }

    @ExceptionHandler({HttpMessageNotReadableException.class, BodyNotValidException.class})
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public ErrorModel bodyNotValidException( Exception ex ) {

        ErrorModel error = new ErrorModel();

        error.setMessage("Body not Valid.");
        error.setError(ex.getMessage());
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
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
