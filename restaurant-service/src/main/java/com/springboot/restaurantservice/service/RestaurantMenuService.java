package com.springboot.restaurantservice.service;

import com.springboot.restaurantservice.dto.request.MenuCreateDto;
import com.springboot.restaurantservice.dto.request.MenuItemRequest;
import com.springboot.restaurantservice.dto.response.MenuItemResponse;
import com.springboot.restaurantservice.dto.response.MenuResponseDto;
import com.springboot.restaurantservice.entity.Menu;
import com.springboot.restaurantservice.entity.MenuItem;
import com.springboot.restaurantservice.repository.MenuItemRepository;
import com.springboot.restaurantservice.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantMenuService {

    private final MenuItemRepository menuItemRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public MenuItemResponse saveSingleItem(MenuItemRequest request) {
        if (request.getPrice() < 0) {
            throw new IllegalArgumentException("Ürün fiyatı 0 TL veya daha az olamaz!");
        }
        MenuItem menu = new MenuItem();
        menu.setName(request.getName());
        menu.setPrice((request.getPrice()));
        menu.setAvailable(true);


        MenuItem savedItem = menuItemRepository.save(menu);

        MenuItemResponse itemResponse = new MenuItemResponse();
        itemResponse.setId(savedItem.getId());
        itemResponse.setName(savedItem.getName());
        itemResponse.setPrice(savedItem.getPrice());
        itemResponse.setAvailable(savedItem.isAvailable());
        return itemResponse;
    }

    @Transactional
    public MenuResponseDto createComboMenu(MenuCreateDto  dto) {
        List<MenuItem> selectedItems = menuItemRepository.findAllById(dto.getItemIds());

        if (selectedItems.isEmpty()) {
            throw new RuntimeException("Seçilen ürünlerden bazıları veritabanında bulunamadı!");
        }

        double totalSinglePrice = selectedItems.stream().mapToDouble(MenuItem::getPrice).sum();
        if (dto.getPrice() >= totalSinglePrice) {
            throw new IllegalArgumentException("\"Kampanyalı menü fiyatı, ürünlerin tekil toplamından (\" \n" +
                    "                    + totalSinglePrice + \" TL) daha ucuz olmalıdır!\");");
        }

        Menu menu = new Menu();
        menu.setName(dto.getName());
        menu.setComboPrice(dto.getPrice());
        menu.setDescription(dto.getDescription());
        menu.setItems(selectedItems);
        menu.setAvailable(true);

        Menu savedMenu = menuRepository.save(menu);

        List<String> itemNames = savedMenu.getItems().stream()
                .map(MenuItem::getName)
                .collect(Collectors.toList());

        return new MenuResponseDto(
                savedMenu.getId(),
                savedMenu.getName(),
                savedMenu.getComboPrice(),
                savedMenu.getDescription(),
                savedMenu.isAvailable(),
                itemNames
        );
    }

    @Transactional
    public List<MenuItemResponse> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();

        return menuItems.stream()
                .map(menuItem -> new MenuItemResponse(
                        menuItem.getId(),
                        menuItem.getName(),
                        menuItem.getPrice(),
                        menuItem.isAvailable()
                ))
                .toList();
    }

    @Transactional
    public List<MenuResponseDto> getAllMenu() {
        List<Menu> menuList = menuRepository.findAll();
        List<MenuResponseDto> menuResponseDtoList = new ArrayList<>();

        for (Menu menu : menuList) {
            List<String> itemNames = menu.getItems().stream()
                    .map(MenuItem::getName)
                    .collect(Collectors.toList());

            MenuResponseDto dto = new MenuResponseDto();
            dto.setId(menu.getId());
            dto.setName(menu.getName());
            dto.setPrice(menu.getComboPrice());
            dto.setAvailable(menu.isAvailable());
            dto.setItemNames(itemNames);
            dto.setDescription(menu.getDescription());

            menuResponseDtoList.add(dto);
        }

        return menuResponseDtoList;
    }

    @Transactional
    public MenuResponseDto getMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(()-> new RuntimeException("Aradığınız Menü bulunamadı!"));

        List<String> names = menu.getItems().stream()
                .map(MenuItem::getName)
                .collect(Collectors.toList());

        MenuResponseDto menuResponseDto = new MenuResponseDto();
        menuResponseDto.setId( menu.getId());
        menuResponseDto.setName(menu.getName());
        menuResponseDto.setPrice(menu.getComboPrice());
        menuResponseDto.setDescription(menu.getDescription());
        menuResponseDto.setAvailable(menu.isAvailable());
        menuResponseDto.setItemNames(names);
        return menuResponseDto;
    }

    @DeleteMapping("/delete-all-menus")
    public void deleteAllMenus() {
        menuItemRepository.deleteAll();
    }
}
