package com.gurume.api.service;

import com.gurume.api.entity.Bill;
import com.gurume.api.entity.DishOrder;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName BillService
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 10:05 AM
 * @Version 1.0
 **/
public interface BillService {

    public Page<Bill> getBillList(Integer pageSize, Integer pageNum, Integer userId);

    public List<Bill> getAllBillList(Integer userId);


    public Bill createBill(Bill bill);

    public DishOrder createDishOrder(DishOrder dishOrder);
}
