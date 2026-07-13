package com.springboot.customerservice.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AddressRequest {

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
