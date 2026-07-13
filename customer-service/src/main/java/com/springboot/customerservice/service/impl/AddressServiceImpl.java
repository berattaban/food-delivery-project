package com.springboot.customerservice.service.impl;

import com.springboot.customerservice.dto.request.AddressRequest;
import com.springboot.customerservice.dto.response.AddressResponse;
import com.springboot.customerservice.entity.Address;
import com.springboot.customerservice.mapper.AddressMapper;
import com.springboot.customerservice.repository.AddressRepository;
import com.springboot.customerservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    @Override
    public AddressResponse createAddress(AddressRequest request) {
        Address address = addressMapper.mapToEntity(request);
        addressRepository.save(address);
        return addressMapper.mapToResponse(address);

    }

    @Override
    public List<AddressResponse> getAllAddresses() {
         return addressMapper.mapToResponseList(addressRepository.findAll());
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
