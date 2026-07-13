package com.springboot.customerservice.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.customerservice.entity.Address;
import jakarta.persistence.*;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","firstName","lastName","email","phoneNumber","address"})
public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;
}
