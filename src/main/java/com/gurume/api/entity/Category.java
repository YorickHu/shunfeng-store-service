package com.gurume.api.entity;

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
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }
}
