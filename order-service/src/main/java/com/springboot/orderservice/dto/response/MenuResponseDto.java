package com.springboot.orderservice.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MenuResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private boolean Available;
    private List<String> itemNames;
}
