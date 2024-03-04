package com.crackit.CircuitBreakerDemo.repository;

import com.crackit.CircuitBreakerDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
