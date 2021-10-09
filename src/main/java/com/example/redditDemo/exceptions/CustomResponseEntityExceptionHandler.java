package com.example.redditDemo.exceptions;

import com.example.redditDemo.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handle(ConstraintViolationException exception) {
        String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Please Check your Input Body",errorMessage);
        return new ResponseEntity<ApiError>(apiError, null, HttpStatus.BAD_REQUEST);
    }
}