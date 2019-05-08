package com.gurume.api.controller;

import com.gurume.api.ServerConfig;
import com.gurume.api.entity.Bill;
import com.gurume.api.entity.DishOrder;
import com.gurume.api.entity.ViewDishOrder;
import com.gurume.api.service.BillService;
import com.gurume.api.service.ViewDishOrderService;
import com.gurume.api.utils.DataFormat;
import com.gurume.api.utils.JSONResult;
import com.gurume.api.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/28 9:05 PM
 * @Version 1.0
 **/
@RestController
@Api(value="订单相关的接口", tags= {"订单相关"})
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    ViewDishOrderService viewDishOrderService;

    @Autowired
    ServerConfig serverConfig;


    @ApiOperation(value="获取订单列表", notes="获取订单列表的接口")
    @GetMapping("/order/list")
    public JSONResult<OrderListVO> getOrderList(@RequestParam(name = "pageNum") Integer pageNum, @RequestParam(name = "pageSize") Integer pageSize, HttpServletRequest request) throws Exception {

        Integer userId = Integer.valueOf(request.getHeader("headerUserId"));
        Page<Bill> billsPage = billService.getBillList(pageSize, pageNum, userId);

        List<Bill> bills = billsPage.getContent();
        List<OrderVO> orderVOS = new ArrayList<>();

        for (Bill bill : bills) {
            List<ViewDishOrder> viewDishOrders = viewDishOrderService.findDishesByOrderId(bill.getId());
            List<DishDetailVO> dishDetailVOS = new ArrayList<>();
            for (ViewDishOrder viewDishOrder : viewDishOrders) {
                DishDetailVO dishDetailVO = new DishDetailVO();
                BeanUtils.copyProperties(viewDishOrder, dishDetailVO);
                dishDetailVO.setName(viewDishOrder.getNam());
                dishDetailVO.setPrice(DataFormat.fenToYuan(viewDishOrder.getPrice().toString()));
                dishDetailVO.setNum(viewDishOrder.getNum().toString());
                dishDetailVO.setPath(serverConfig.getUrl() + viewDishOrder.getPath());
                dishDetailVOS.add(dishDetailVO);
            }
            OrderVO orderVO = new OrderVO();
            orderVO.setId(bill.getId());
            orderVO.setDishes(dishDetailVOS);
            orderVO.setPayPrice(DataFormat.fenToYuan(bill.getPayPrice().toString()));
            orderVO.setReserveTime(DataFormat.dateToString(bill.getReserve()));
            if (bill.getDiscount() == 100 ){
                orderVO.setDiscount("无折扣");
            }else {
                orderVO.setDiscount(DataFormat.percentToDiscount(bill.getDiscount().toString()) + "折");
            }
            orderVO.setStatus(1 == bill.getStat() ? "未支付" : "已支付");
            orderVOS.add(orderVO);
        }
        OrderListVO orderListVO = new OrderListVO();
        orderListVO.setPageSize(pageSize.toString());
        orderListVO.setPageNum(pageNum.toString());
        orderListVO.setOrderVOS(orderVOS);


        return JSONResult.ok(orderListVO);
    }

    @ApiOperation(value="新建订单", notes="新建订单的接口")
    @PostMapping("/order")
    public JSONResult<OrderVO> createOrder(@RequestBody OrderVO orderVO, HttpServletRequest request) throws Exception {

        Integer userId = Integer.valueOf(request.getHeader("headerUserId"));

        Bill bill = new Bill();
        bill.setReserve(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(orderVO.getReserveTime()));
        bill.setCreateTime(new Date());
        bill.setStat(1);
        bill.setPayPrice(Integer.parseInt(DataFormat.yuanToFen(orderVO.getPayPrice())));
        bill.setDiscount(Integer.valueOf(DataFormat.discountToPercent(orderVO.getDiscount())));
        bill.setUserInfo(userId);
        billService.createBill(bill);

        for (DishDetailVO dishDetailVO : orderVO.getDishes()) {
            DishOrder dishOrder = new DishOrder();
            dishOrder.setDishId(dishDetailVO.getId());
            dishOrder.setNum(Integer.valueOf(dishDetailVO.getNum()));
            dishOrder.setOrderId(bill.getId());
            dishOrder.setPrice(Integer.valueOf(DataFormat.yuanToFen(dishDetailVO.getPrice())));
            billService.createDishOrder(dishOrder);
        }


        return JSONResult.ok();
    }

//    @ApiOperation(value="支付下单", notes="支付下单接口")
//    @PostMapping("/bill")
//    public JSONResult createBill(@RequestBody PayOrderVO payOrderVO, HttpServletRequest request) throws Exception {
//
//    }
//
//    @ApiOperation(value="订单查询", notes="订单查询接口")
//    @GetMapping("/bill")
//    public JSONResult<OrderVO> getBill(@RequestBody PayOrderVO payOrderVO, HttpServletRequest request) throws Exception {
//
//    }
}
