package com.springboot.orderservice.entity;

public enum OrderStatus {
    PENDING,      // Sipariş alındı, onay veya ödeme bekliyor
    PREPARING,    // Restoran siparişi hazırlıyor
    DELIVERED,    // Teslim edildi
    CANCELLED
}
