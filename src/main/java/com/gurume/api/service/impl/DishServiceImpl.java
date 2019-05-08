package com.gurume.api.service.impl;

import com.gurume.api.entity.Dish;
import com.gurume.api.repository.DishRepository;
import com.gurume.api.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DishServiceImpl
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/1 10:51 PM
 * @Version 1.0
 **/
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;

    @Override
    public List<Dish> getDishList() {
        return dishRepository.findAllByStat(1);
    }
}
