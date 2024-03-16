package com.crackit.AddressCircuitBreakerDemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AddressExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressServiceException.class)
    protected ResponseEntity<ErrorResponse> handleAddressServiceException(AddressServiceException ex) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .code(ex.getCode())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .code(ErrorCode.INTERNAL_SERVER_ERROR)
                        .message("Exception in address Service" + ex)
                        .build());
    }
}
