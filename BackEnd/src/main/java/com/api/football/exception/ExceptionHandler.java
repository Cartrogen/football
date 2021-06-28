package com.api.football.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {DataNotFoundException.class})
    public final ResponseEntity<ApiError> DataNotFound(DataNotFoundException ex) throws DataNotFoundException {
        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Client is required to send a valid input");
        return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
