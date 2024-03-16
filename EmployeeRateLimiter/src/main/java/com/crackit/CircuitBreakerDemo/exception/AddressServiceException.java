package com.crackit.CircuitBreakerDemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressServiceException extends RuntimeException {

    private String message;
    private String code;
    public AddressServiceException(String message) {
        super(message);
    }
}
