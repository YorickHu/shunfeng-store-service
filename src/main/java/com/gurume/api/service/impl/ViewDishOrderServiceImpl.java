package com.gurume.api.service.impl;

import com.gurume.api.entity.ViewDishOrder;
import com.gurume.api.repository.ViewDishOrderRepository;
import com.gurume.api.service.ViewDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ViewDishOrderServiceImpl
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 11:36 AM
 * @Version 1.0
 **/
@Service
public class ViewDishOrderServiceImpl implements ViewDishOrderService {

    @Autowired
    ViewDishOrderRepository viewDishOrderRepository;

    @Override
    public List<ViewDishOrder> findDishesByOrderId(Integer orderId) {
        return viewDishOrderRepository.findAllByOrderId(orderId);
    }
}
