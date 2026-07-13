package com.springboot.restaurantservice.repository;

import com.springboot.restaurantservice.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
