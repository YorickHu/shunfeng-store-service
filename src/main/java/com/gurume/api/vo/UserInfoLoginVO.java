package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 11:21 AM
 * @Version 1.0
 **/
@ApiModel(value="用户登录对象", description="下行返回id")
public class UserInfoLoginVO {

    @ApiModelProperty(value="id", name="id", example="hyyy", required=false)
    private String id;

    @ApiModelProperty(value="手机", name="loginName", example="hyyy", required=true)
    private String loginName;

    @ApiModelProperty(value="密码", name="pwd", example="123456", required=true)
    private String pwd;

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
}
