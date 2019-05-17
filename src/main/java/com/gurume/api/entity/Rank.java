package com.gurume.api.entity;

import javax.persistence.*;

/**
 * @ClassName Rank
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/1 3:54 PM
 * @Version 1.0
 **/
@Entity
@Table(name = "rank")
public class Rank {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer num;

    private String nam;

    private Integer threshhold;

    private Integer discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Integer getThreshhold() {
        return threshhold;
    }

    public void setThreshhold(Integer threshhold) {
        this.threshhold = threshhold;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
