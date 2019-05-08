package com.gurume.api.service.impl;

import com.gurume.api.entity.Bill;
import com.gurume.api.entity.DishOrder;
import com.gurume.api.repository.BillRepository;
import com.gurume.api.repository.DishOrderRepository;
import com.gurume.api.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BillServiceImpl
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 10:07 AM
 * @Version 1.0
 **/
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    DishOrderRepository dishOrderRepository;

    @Override
    public Page<Bill> getBillList(Integer pageSize, Integer pageNum, Integer userId) {
        Pageable pageable = new PageRequest(pageNum,pageSize, Sort.Direction.DESC,"create_time");
        return billRepository.findAllByUserInfo(userId, pageable);
    }

    @Override
    public List<Bill> getAllBillList(Integer userId) {
        return billRepository.findAllByUserInfoAndStat(userId, 2);// 只筛选已支付的
    }

    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public DishOrder createDishOrder(DishOrder dishOrder) {
        return dishOrderRepository.save(dishOrder);
    }


}
