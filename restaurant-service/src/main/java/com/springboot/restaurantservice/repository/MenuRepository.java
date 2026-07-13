package com.springboot.restaurantservice.repository;

import com.springboot.restaurantservice.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
