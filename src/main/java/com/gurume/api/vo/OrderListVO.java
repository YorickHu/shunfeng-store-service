package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName OrderListVO
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 10:19 AM
 * @Version 1.0
 **/
@ApiModel(value="订单列表对象", description="订单列表")
@Getter
@Setter
public class OrderListVO {

    @ApiModelProperty(value="页数", name="pageNum", example="2", required=true)
    private String pageNum;

    @ApiModelProperty(value="分页大小", name="pageSize", example="8", required=true)
    private String pageSize;

    @ApiModelProperty(value="菜品清单", name="dishes", example="", required=true)
    private List<OrderVO> orderVOS;


}
