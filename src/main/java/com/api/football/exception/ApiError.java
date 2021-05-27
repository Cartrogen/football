package com.api.football.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError {

    private String errorMessage;
    private HttpStatus httpStatus;
    private int errorCode;
    private String documentation;

}
