package com.springboot.customerservice.service.impl;

import com.springboot.customerservice.dto.request.CustomerRequest;
import com.springboot.customerservice.dto.response.CustomerResponse;
import com.springboot.customerservice.entity.Customer;
import com.springboot.customerservice.mapper.AddressMapper;
import com.springboot.customerservice.mapper.CustomerMapper;
import com.springboot.customerservice.repository.CustomerRepository;
import com.springboot.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressMapper addressMapper;

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.mapToEntity(request);
        customerRepository.save(customer);
        return customerMapper.mapToResponse(customer);
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Müşteri bulunamadı! ID: " + id));
        return customerMapper.mapToResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerMapper.mapToResponseList(customerRepository.findAll());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
