package com.springboot.orderservice.client;

import com.springboot.orderservice.dto.response.MenuResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service")
public interface RestaurantClient {

    @GetMapping("/api/v1/restaurant/management/get-menu-by-id/{id}")
    MenuResponseDto getMenuById(@PathVariable("id") Long id);

}
