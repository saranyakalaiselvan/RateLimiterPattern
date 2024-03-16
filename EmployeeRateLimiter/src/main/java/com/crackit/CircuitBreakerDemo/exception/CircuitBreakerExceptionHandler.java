package com.crackit.CircuitBreakerDemo.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    @ExceptionHandler(RequestNotPermitted.class)
    protected ResponseEntity<ErrorResponse> handleEmployeeServiceException(RequestNotPermitted empEx) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body(ErrorResponse.builder()
                        .code("EMP-SERVICE")
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
