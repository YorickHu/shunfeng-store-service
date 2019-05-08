package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName UserDetailsVO
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 11:21 AM
 * @Version 1.0
 **/
@ApiModel(value="用户详情对象", description="下行返回id")
@Getter
@Setter
public class UserDetailsVO {

    @ApiModelProperty(value="id", name="id", example="hyyy", required=false)
    private Integer id;

    @ApiModelProperty(value="手机", name="loginName", example="17823490689")
    private String loginName;

    @ApiModelProperty(value="昵称", name="nickname", example="Yorick")
    private String nickname;

    @ApiModelProperty(value="年龄", name="age", example="18")
    private Integer age;

    @ApiModelProperty(value="会员等级", name="rank", example="1")
    private String rank;

    @ApiModelProperty(value="等级名称", name="rankName", example="金牌")
    private String rankName;

    @ApiModelProperty(value="享受优惠", name="discount", example="75")
    private String discount;

    @ApiModelProperty(value="消费总额", name="amount", example="1034.98")
    private String amount;

}
