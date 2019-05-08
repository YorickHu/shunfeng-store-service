package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName OrderDetailsVO
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 11:21 AM
 * @Version 1.0
 **/
@ApiModel(value="订单详情对象", description="单个订单的详情")
@Getter
@Setter
public class OrderVO {

    @ApiModelProperty(value="订单id", name="id", example="23rf224fw23t2fwet2f", required=true)
    private Integer id;

    @ApiModelProperty(value="菜品清单", name="dishes", example="", required=true)
    private List<DishDetailVO> dishes;

    @ApiModelProperty(value="实际付款", name="payPrice", example="28.00")
    private String payPrice;

    @ApiModelProperty(value="享受优惠", name="discount", example="75")
    private String discount;

    @ApiModelProperty(value="订单状态", name="status", example="已支付")
    private String status;

    @ApiModelProperty(value="预约时间", name="reserveTime", example="2019-05-08 00:00:00")
    private String reserveTime;
}
