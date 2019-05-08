package com.gurume.api.service;

import com.gurume.api.entity.ViewDishOrder;

import java.util.List;

public interface ViewDishOrderService {

    public List<ViewDishOrder> findDishesByOrderId(Integer orderId);
}
