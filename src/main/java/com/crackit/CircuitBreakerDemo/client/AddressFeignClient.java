package com.crackit.CircuitBreakerDemo.client;

import com.crackit.CircuitBreakerDemo.config.CustomFeignClientConfiguration;
import com.crackit.CircuitBreakerDemo.dto.AddressDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address-service",
url = "http://localhost:8080/circuit-breaker/v1/crackit",
        configuration = CustomFeignClientConfiguration.class)
public interface AddressFeignClient {

    @GetMapping("/employees/{employeeId}/address")
    @RateLimiter(name = "address-service")
    AddressDTO getAddress(@PathVariable("employeeId") Integer employeeId);

}
