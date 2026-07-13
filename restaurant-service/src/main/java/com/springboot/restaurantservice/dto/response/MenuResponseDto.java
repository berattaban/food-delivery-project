package com.springboot.restaurantservice.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.restaurantservice.entity.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id","name","price","description","available","itemNames"})
public class MenuResponseDto {

    public MenuResponseDto(Long id, String name, Double price, boolean Available, List<String> itemNames) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Available = Available;
        this.itemNames = itemNames;
    }

    private Long id;
    private String name;
    private Double price;
    private String description;
    private boolean Available;
    private List<String> itemNames;
}
