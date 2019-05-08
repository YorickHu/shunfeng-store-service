package com.gurume.api.entity;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class Rank {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer num;

    private String nam;

    private Integer threshhold;

    private Integer discount;


}
