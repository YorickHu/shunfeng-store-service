package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 11:21 AM
 * @Version 1.0
 **/
@ApiModel(value="用户登录对象", description="下行返回id")
@Getter
@Setter
public class UserInfoLoginVO {

    @ApiModelProperty(value="id", name="id", example="hyyy", required=false)
    private String id;

    @ApiModelProperty(value="手机", name="loginName", example="hyyy", required=true)
    private String loginName;

    @ApiModelProperty(value="密码", name="pwd", example="123456", required=true)
    private String pwd;

}
