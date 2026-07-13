package com.springboot.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "menu_id", nullable = false)
    private Long menuId;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Column(name = "order_status", nullable = false)
    private String orderStatus; // PENDING, PREPARING, SHIPPED, DELIVERED

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
