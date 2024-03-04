package com.crackit.CircuitBreakerDemo.exception;

public class EmployeeNotFoundException extends EmployeeServiceException {
    public  EmployeeNotFoundException() {
        super("Requested employeeId is invalid." , ErrorCode.EMPLOYEE_NOT_FOUND);
    }

    public EmployeeNotFoundException(String message) {
        super(message, ErrorCode.EMPLOYEE_NOT_FOUND);
    }
}
