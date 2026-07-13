package com.springboot.customerservice.mapper;

import com.springboot.customerservice.dto.request.CustomerRequest;
import com.springboot.customerservice.dto.response.CustomerResponse;
import com.springboot.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse mapToResponse(Customer customer);
    Customer mapToEntity(CustomerRequest request);
    void updateCustomerFromRequest(CustomerRequest request, @MappingTarget Customer customer);
    List<CustomerResponse> mapToResponseList(List<Customer> customers);

}
