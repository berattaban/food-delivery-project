package com.springboot.orderservice.controller;

import com.springboot.orderservice.dto.request.OrderRequest;
import com.springboot.orderservice.dto.response.OrderResponse;
import com.springboot.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse savedOrder = orderService.createOrder(orderRequest);
        String responseMessage = String.format(
                "🎉 Siparişiniz Başarıyla Alındı!\n\n" +
                        "🆔 Sipariş Numarası: %s\n" +
                        "🍔 Menü Numarası: #%d\n" +
                        "💰 Toplam Tutar: %.2f TL\n" +
                        "⏳ Sipariş Durumu: ⏳ BEKLEMEDE (Restoran onayı bekleniyor...)\n" +
                        "📅 Tarih: %s",
                savedOrder.getId(),
                savedOrder.getMenuId(),
                savedOrder.getTotalPrice(),
                savedOrder.getCreatedAt()
        );
        return ResponseEntity.ok(responseMessage);
    }
}
