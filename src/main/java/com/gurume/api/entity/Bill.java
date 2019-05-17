package com.gurume.api.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 10:23 AM
 * @Version 1.0
 **/
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String num;

    private Date reserve;

    private Integer totalPrice;

    private Date createTime;

    private Integer stat;

    private Integer payPrice;

    private Integer discount;

    private Integer userInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getReserve() {
        return reserve;
    }

    public void setReserve(Date reserve) {
        this.reserve = reserve;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Integer payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Integer userInfo) {
        this.userInfo = userInfo;
    }
}
