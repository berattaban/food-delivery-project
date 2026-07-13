package com.springboot.customerservice.service;

import com.springboot.customerservice.dto.request.CustomerRequest;
import com.springboot.customerservice.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest request);
    CustomerResponse getCustomerById(Long id);
    List<CustomerResponse> getAllCustomers();
    void deleteCustomer(Long id);
}
