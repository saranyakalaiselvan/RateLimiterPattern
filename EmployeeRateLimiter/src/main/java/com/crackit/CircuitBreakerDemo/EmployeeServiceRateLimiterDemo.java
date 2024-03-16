package com.crackit.CircuitBreakerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceRateLimiterDemo {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceRateLimiterDemo.class, args);
	}

}
