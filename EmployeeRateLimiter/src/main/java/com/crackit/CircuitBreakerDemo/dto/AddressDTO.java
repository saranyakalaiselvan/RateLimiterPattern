package com.crackit.CircuitBreakerDemo.dto;

public record AddressDTO(Integer id,
                         String streetName,
                         String suburb,
                         String city,
                         Integer postCode,
                         Integer employeeId) {
}
