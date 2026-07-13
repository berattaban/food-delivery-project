package com.springboot.orderservice.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {

    private Long customerId;
    private Long menuId;
    private double totalPrice;
    private LocalDateTime createdAt = LocalDateTime.now();

}
