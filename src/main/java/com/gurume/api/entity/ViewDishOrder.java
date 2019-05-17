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
@Table(name = "view_dish_order")
public class ViewDishOrder {

    @Id
    private Integer id;

    private String path;

    private String nam;

    private Integer price;

    private Integer num;

    private Integer orderId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
