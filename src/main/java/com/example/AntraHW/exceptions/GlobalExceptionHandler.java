package com.example.AntraHW.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ExecutionException.class, InterruptedException.class})
    public ResponseEntity<String> handleExecutionExceptions(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Bad Request: " + ex.getMessage());
    }
}

