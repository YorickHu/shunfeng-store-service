package com.gurume.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
@Getter
@Setter
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

}
