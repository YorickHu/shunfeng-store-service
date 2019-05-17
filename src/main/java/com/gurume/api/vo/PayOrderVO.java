package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName PayOrderVO
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 11:21 AM
 * @Version 1.0
 **/
@ApiModel(value="支付下单请求", description="请求下单")
public class PayOrderVO {


    @ApiModelProperty(value="订单号", name="orderNo", example="1241242e312e1d", required=true)
    private Integer orderNo;

    @ApiModelProperty(value="订单金额", name="amount", example="23.00", required=true)
    private Integer amount;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
