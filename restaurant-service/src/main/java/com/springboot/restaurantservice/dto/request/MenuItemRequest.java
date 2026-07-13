package com.springboot.restaurantservice.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class MenuItemRequest {

    private String name;
    private double price;
    private boolean Available;
}
