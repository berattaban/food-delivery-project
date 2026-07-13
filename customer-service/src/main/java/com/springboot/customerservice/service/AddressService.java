package com.springboot.customerservice.service;

import com.springboot.customerservice.dto.request.AddressRequest;
import com.springboot.customerservice.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    AddressResponse createAddress(AddressRequest request);
    List<AddressResponse> getAllAddresses();
    void deleteAddress(Long id);


}
