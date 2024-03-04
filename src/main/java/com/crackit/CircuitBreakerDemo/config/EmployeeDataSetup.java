package com.crackit.CircuitBreakerDemo.config;

import com.crackit.CircuitBreakerDemo.entity.Employee;
import com.crackit.CircuitBreakerDemo.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class EmployeeDataSetup {
    private final EmployeeRepository employeeRepository;

    public EmployeeDataSetup(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void setupData(){
        employeeRepository.saveAll(Arrays.asList(
                Employee.builder().employeeId(1).employeeName("Crackit").build(),
                Employee.builder().employeeId(2).employeeName("TechieTalks").build(),
                Employee.builder().employeeId(3).employeeName("Crackit TechieTalks").build()
        ));
    }
}
