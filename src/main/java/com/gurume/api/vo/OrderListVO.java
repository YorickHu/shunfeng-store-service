package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName OrderListVO
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 10:19 AM
 * @Version 1.0
 **/
@ApiModel(value="订单列表对象", description="订单列表")
public class OrderListVO {

    @ApiModelProperty(value="页数", name="pageNum", example="2", required=true)
    private String pageNum;

    @ApiModelProperty(value="分页大小", name="pageSize", example="8", required=true)
    private String pageSize;

    @ApiModelProperty(value="菜品清单", name="dishes", example="", required=true)
    private List<OrderVO> orderVOS;

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public List<OrderVO> getOrderVOS() {
        return orderVOS;
    }

    public void setOrderVOS(List<OrderVO> orderVOS) {
        this.orderVOS = orderVOS;
    }
}
