package com.example.demo.exception;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

public enum ErrorMessage {

    EMPLOYEE_NOT_FOUND("Employee Not Found"),
    COMPANY_NOT_FOUND("Company Not Found");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
