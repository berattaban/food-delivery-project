package com.springboot.orderservice.dto.request;

import lombok.Data;

@Data
public class OrderCreate {

    private Long customerId;
    private Long menuId;
}
