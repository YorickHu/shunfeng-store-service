package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 11:21 AM
 * @Version 1.0
 **/
@ApiModel(value="用户注册对象", description="下行返回id")//notes：这个value，一定不要有重复
public class UserInfoRegistVO {

    @ApiModelProperty(value="id", name="id", example="hyyy", required=false)
    private String id;

    @ApiModelProperty(value="手机", name="loginName", example="hyyy", required=true)
    @NotBlank(message = "用户名不能为空！")
    private String loginName;

    @ApiModelProperty(value="密码", name="pwd", example="123456", required=true)
    @NotBlank(message = "密码不能为空！")
    private String pwd;

    @ApiModelProperty(value="年龄", name="age", example="12", required=true)
    @NotNull(message = "年龄不能为空！")
    private Integer age;

    @ApiModelProperty(value="昵称", name="nickname", example="Yorick", required=true)
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
