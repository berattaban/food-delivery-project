package com.springboot.orderservice.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderResponse {

    private UUID id;
    private Long customerId;
    private Long menuId;
    private double totalPrice;
    private String orderStatus;
    private LocalDateTime createdAt = LocalDateTime.now();
}
