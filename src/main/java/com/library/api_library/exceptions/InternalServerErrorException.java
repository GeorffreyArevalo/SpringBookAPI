package com.library.api_library.exceptions;

public class InternalServerErrorException extends RuntimeException{
    
    public InternalServerErrorException(String message) {
        super(message);
    }

}
