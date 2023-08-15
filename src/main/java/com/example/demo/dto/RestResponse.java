package com.example.demo.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class RestResponse<T> {

    private T data;
    private Date responseDate;
    private boolean isSuccess;
    private HttpStatus httpStatus;
    private String message;

    private RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
    }

    private RestResponse(T data, boolean isSuccess, HttpStatus httpStatus) {
        this(data, isSuccess);
        this.httpStatus = httpStatus;
        this.responseDate = new Date();
    }

    private RestResponse(T data, boolean isSuccess, String message, HttpStatus httpStatus) {
        this(data, isSuccess, httpStatus);
        this.message = message;
    }

    public static <T> RestResponse<T> of(T t, String message, HttpStatus httpStatus) {
        return new RestResponse<>(t, true, message, httpStatus);
    }

    public static <T> RestResponse<T> of(T t, HttpStatus httpStatus) {
        return new RestResponse<>(t, true, httpStatus);
    }

    public static <T> RestResponse<T> error(T t, String message, HttpStatus httpStatus) {
        return new RestResponse<>(t, false, message, httpStatus);
    }
}