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
@Table(name = "dish_order")
@Getter
@Setter
public class DishOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer dishId;

    private Integer orderId;

    private Integer price;

    private Integer num;


}
