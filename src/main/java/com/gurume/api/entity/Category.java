package com.gurume.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @ClassName Class
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 10:11 AM
 * @Version 1.0
 **/
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nam;


}
