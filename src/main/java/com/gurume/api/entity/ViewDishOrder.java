package com.gurume.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @ClassName DishOrder
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 10:22 AM
 * @Version 1.0
 **/
@Entity
@Table(name = "view_dish_order")
@Getter
@Setter
public class ViewDishOrder {

    @Id
    private Integer id;

    private String path;

    private String nam;

    private Integer price;

    private Integer num;

    private Integer orderId;


}
