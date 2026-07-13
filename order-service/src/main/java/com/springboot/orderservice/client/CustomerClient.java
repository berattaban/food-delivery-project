package com.springboot.orderservice.client;

import com.springboot.orderservice.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/rest/api/customers/get-by-id/{id}")
    CustomerResponse findById(@PathVariable("id") Long id);
}
