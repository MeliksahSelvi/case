package com.example.demo.exception;

import com.example.demo.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

@RestController
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final RestResponse<Object> handleEmployeeNotFoundExceptions(NotFoundException exception, WebRequest webRequest) {

        String message=exception.getMessage();

        return RestResponse.error(null,message, HttpStatus.NOT_FOUND);
    }
}
