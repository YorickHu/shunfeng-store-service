package com.gurume.api.repository;

import com.gurume.api.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    public List<Dish> findAllByStat(Integer stat);
}
