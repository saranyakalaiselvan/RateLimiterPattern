package com.crackit.CircuitBreakerDemo.dto;

public record EmployeeDTO(Integer employeeId,
                          String employeeName,
                          AddressDTO addressDTO) {
}
