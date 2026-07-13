package com.springboot.orderservice.service;

import com.springboot.orderservice.client.CustomerClient;
import com.springboot.orderservice.client.RestaurantClient;
import com.springboot.orderservice.dto.request.OrderRequest;
import com.springboot.orderservice.dto.response.CustomerResponse;
import com.springboot.orderservice.dto.response.MenuResponseDto;
import com.springboot.orderservice.dto.response.OrderResponse;
import com.springboot.orderservice.entity.Order;
import com.springboot.orderservice.entity.OrderStatus;
import com.springboot.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final RestaurantClient restaurantClient;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        CustomerResponse customerExists = customerClient.findById(orderRequest.getCustomerId());
        if (customerExists == null) {
            throw new RuntimeException("Müşteri bulunamadı! Sipariş Geçersiz ❌");
        }

        MenuResponseDto menu = restaurantClient.getMenuById(orderRequest.getMenuId());
        if (menu == null) {
            throw new RuntimeException("Menü bulunamadı! Sipariş Geçersiz ❌");
        }

        if (orderRequest.getTotalPrice() != menu.getPrice()){
            throw new RuntimeException("Gönderilen tutar, menü fiyatından düşük olamaz! ❌");
        }

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(UUID.randomUUID());
        orderResponse.setCustomerId(orderRequest.getCustomerId());
        orderResponse.setMenuId(orderRequest.getMenuId());
        orderResponse.setTotalPrice(orderRequest.getTotalPrice());
        orderResponse.setOrderStatus(OrderStatus.PENDING.toString());
        orderResponse.setCreatedAt(orderRequest.getCreatedAt());
        return orderResponse;
    }
}
