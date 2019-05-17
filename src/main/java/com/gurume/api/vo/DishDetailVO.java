package com.gurume.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName OrderDishDetailVO
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/28 9:55 PM
 * @Version 1.0
 **/
@ApiModel(value="菜品详情对象", description="菜品信息")
public class DishDetailVO {

    @ApiModelProperty(value="菜品id", name="id", example="12312", required=true)
    private Integer id;

    @ApiModelProperty(value="菜品名", name="dishName", example="青椒皮蛋")
    private String name;

    @ApiModelProperty(value="份数", name="dishNum", example="3")
    private String num;

    @ApiModelProperty(value="菜品价格", name="dishPrice", example="14.00")
    private String price;

    @ApiModelProperty(value="菜品详情", name="dishDetails", example="凉性，由青椒和皮蛋精心炒制而成")
    private String descr;

    @ApiModelProperty(value="主图路径", name="dishPic", example="/pic/qingjiaopidan.jpg")
    private String path;

    @ApiModelProperty(value="分类标记", name="flag", example="food/drink")
    private String flag;

    @ApiModelProperty(value="状态", name="status", example="true/false是否推荐")
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
