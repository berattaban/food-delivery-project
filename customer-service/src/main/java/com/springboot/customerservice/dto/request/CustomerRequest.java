package com.springboot.customerservice.dto.request;

import com.springboot.customerservice.entity.Address;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;
}
