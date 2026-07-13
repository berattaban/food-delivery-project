package com.springboot.restaurantservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MenuCreateDto {

    private String name;
    private double price;
    private String description;
    private List<Long> itemIds;
}
