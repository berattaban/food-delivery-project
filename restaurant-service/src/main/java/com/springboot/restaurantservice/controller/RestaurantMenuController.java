package com.springboot.restaurantservice.controller;

import com.springboot.restaurantservice.dto.request.MenuCreateDto;
import com.springboot.restaurantservice.dto.request.MenuItemRequest;
import com.springboot.restaurantservice.dto.response.MenuItemResponse;
import com.springboot.restaurantservice.dto.response.MenuResponseDto;
import com.springboot.restaurantservice.service.RestaurantMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant/management")
@RequiredArgsConstructor
public class RestaurantMenuController {

    private final RestaurantMenuService restaurantMenuService;

    @PostMapping("/items")
    public ResponseEntity<String> addSingleItem(@RequestBody MenuItemRequest itemRequest) {
        MenuItemResponse itemResponse = restaurantMenuService.saveSingleItem(itemRequest);

        String message = String.format(
                "Harika haber! '%s' menümüze başarıyla eklendi. Satış fiyatı %f TL olarak belirlenmiştir.",
                itemResponse.getName(),
                itemResponse.getPrice()
        );
        return ResponseEntity.ok(message);

    }

    @PostMapping("/menus")
    public ResponseEntity<MenuResponseDto> createComboMenu(@RequestBody MenuCreateDto menuCreateDto) {
        MenuResponseDto response = restaurantMenuService.createComboMenu(menuCreateDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all-items")
    public ResponseEntity<List<MenuItemResponse>> getAllMenuItems() {
        return ResponseEntity.ok(restaurantMenuService.getAllMenuItems());
    }

    @GetMapping("/get-all-menus")
    public ResponseEntity<List<MenuResponseDto>> getAllMenus() {
        return ResponseEntity.ok(restaurantMenuService.getAllMenu());
    }

    @GetMapping("/get-menu-by-id/{id}")
    public ResponseEntity<MenuResponseDto> getMenuById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(restaurantMenuService.getMenuById(id));
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAll() {
       restaurantMenuService.deleteAllMenus();
        return ResponseEntity.ok("Tüm menüler başarıyla silindi!");
    }

}
