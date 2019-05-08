package com.gurume.api.repository;

import com.gurume.api.entity.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishOrderRepository extends JpaRepository<DishOrder, Integer>{


}
