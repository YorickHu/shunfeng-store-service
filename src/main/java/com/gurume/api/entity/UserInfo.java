package com.gurume.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 10:26 AM
 * @Version 1.0
 **/
@Entity
@Data
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String loginName;

    private String pwd;

    private Integer rank;

    private Timestamp createTime;

    private Integer age;

    private String nickname;

}
