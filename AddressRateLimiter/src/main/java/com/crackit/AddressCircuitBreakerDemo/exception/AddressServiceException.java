package com.crackit.AddressCircuitBreakerDemo.exception;

import lombok.*;

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
