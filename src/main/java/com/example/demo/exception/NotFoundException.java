package com.example.demo.exception;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

public class NotFoundException extends RuntimeException{

    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage.toString());
    }
}
