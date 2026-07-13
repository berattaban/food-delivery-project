package com.springboot.customerservice.mapper;

import com.springboot.customerservice.dto.request.AddressRequest;
import com.springboot.customerservice.dto.response.AddressResponse;
import com.springboot.customerservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponse mapToResponse(Address address);
    Address mapToEntity(AddressRequest request);
    void updateAddressFromRequest(AddressRequest request, @MappingTarget Address address);
    List<AddressResponse> mapToResponseList(List<Address> addresses);
}
