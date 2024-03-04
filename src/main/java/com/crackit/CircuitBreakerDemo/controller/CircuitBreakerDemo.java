package com.crackit.CircuitBreakerDemo.controller;

import com.crackit.CircuitBreakerDemo.dto.EmployeeDTO;
import com.crackit.CircuitBreakerDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit-breaker/v1/crackit")
public class CircuitBreakerDemo {

    private final EmployeeService employeeService;

    public CircuitBreakerDemo(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeDTO getEmployees(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.getEmployees(employeeId);
    }
}
