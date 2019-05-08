package com.gurume.api.repository;

import com.gurume.api.entity.ViewDishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName ViewDishOrderRepository
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 11:33 AM
 * @Version 1.0
 **/
public interface ViewDishOrderRepository extends JpaRepository<ViewDishOrder, Integer> {

    @Query(value = "SELECT * FROM gurume.view_dish_order WHERE order_id = ?1",
            nativeQuery = true)
    public List<ViewDishOrder> findAllByOrderId(Integer orderId);

}
