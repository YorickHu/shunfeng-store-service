package com.gurume.api.entity;

import jdk.nashorn.internal.objects.annotations.Setter;

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
public class DishOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer dishId;

    private Integer orderId;

    private Integer price;

    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
