package com.crackit.CircuitBreakerDemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CircuitBreakerExceptionHandler {

    @ExceptionHandler(AddressServiceException.class)
    protected ResponseEntity<ErrorResponse> handleAddressServiceException(AddressServiceException addEx) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .code(addEx.getCode())
                        .message(addEx.getMessage())
                        .build());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleEmployeeServiceException(EmployeeNotFoundException empEx) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .code(empEx.getCode())
                        .message(empEx.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .code("EMP-SERVICE")
                        .message(ex.getMessage() != null ? ex.getMessage() : "Exception in employee service")
                        .build());
    }
}
