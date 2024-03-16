package com.crackit.CircuitBreakerDemo.service;

import com.crackit.CircuitBreakerDemo.client.AddressFeignClient;
import com.crackit.CircuitBreakerDemo.dto.AddressDTO;
import com.crackit.CircuitBreakerDemo.dto.EmployeeDTO;
import com.crackit.CircuitBreakerDemo.entity.Employee;
import com.crackit.CircuitBreakerDemo.exception.EmployeeNotFoundException;
import com.crackit.CircuitBreakerDemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressFeignClient addressFeignClient;

    public EmployeeService(EmployeeRepository employeeRepository, AddressFeignClient addressFeignClient) {
        this.employeeRepository = employeeRepository;
        this.addressFeignClient = addressFeignClient;
    }

    public EmployeeDTO getEmployees(Integer employeeId) {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                () ->  new EmployeeNotFoundException("No Employee Found with employeeId: " + employeeId
        ));
        AddressDTO address = addressFeignClient.getAddress(employeeId);
        return mapper(employee, address);
    }

    private EmployeeDTO mapper(Employee employee, AddressDTO address) {
        return new EmployeeDTO(employee.getEmployeeId(),
                employee.getEmployeeName(),
                address);
    }
}
