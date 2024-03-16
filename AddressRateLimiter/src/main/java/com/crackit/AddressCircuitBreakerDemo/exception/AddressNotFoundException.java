package com.crackit.AddressCircuitBreakerDemo.exception;

public class AddressNotFoundException extends AddressServiceException {
    public  AddressNotFoundException() {
        super("Requested address is invalid." , ErrorCode.ADDRESS_NOT_FOUND);
    }

    public AddressNotFoundException(String message) {
        super(message, ErrorCode.ADDRESS_NOT_FOUND);
    }
}
