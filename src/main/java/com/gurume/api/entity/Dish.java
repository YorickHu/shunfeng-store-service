package com.gurume.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @ClassName Dish
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 10:17 AM
 * @Version 1.0
 **/
@Entity
@Table(name = "dish")
@Getter
@Setter
public class Dish {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nam;

    private Integer price;

    private String path;

    private Integer category;

    private Integer stock;

    private String descr;

    private Integer stat;

    private String age;

    private String season;



}
