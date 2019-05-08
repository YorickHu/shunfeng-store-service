package com.gurume.api.controller;

import com.gurume.api.entity.Bill;
import com.gurume.api.entity.Rank;
import com.gurume.api.entity.UserInfo;
import com.gurume.api.service.BillService;
import com.gurume.api.service.RankService;
import com.gurume.api.service.UserInfoService;
import com.gurume.api.utils.DataFormat;
import com.gurume.api.utils.JSONResult;
import com.gurume.api.vo.UserDetailsVO;
import com.gurume.api.vo.UserInfoRegistVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/28 8:46 PM
 * @Version 1.0
 **/
@RestController
@Api(value="用户相关的接口", tags= {"用户信息相关"})
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    RankService rankService;

    @Autowired
    BillService billService;

    @ApiOperation(value="获取用户信息", notes="获取用户信息的接口")
    @GetMapping("/user/details")
    public JSONResult<UserDetailsVO> getUserDetails(HttpServletRequest request) throws Exception {
        Integer userId = Integer.valueOf(request.getHeader("headerUserId"));
        UserInfo userInfo = userInfoService.findById(userId);
        if (userId != null) {
            UserDetailsVO userDetailsVO = new UserDetailsVO();
            BeanUtils.copyProperties(userInfo, userDetailsVO);
            Rank rank = rankService.findByNum(1);
            List<Bill> bills = billService.getAllBillList(userId);
            Integer totalAmount = 0;
            for (Bill bill : bills) {
                totalAmount = totalAmount + bill.getPayPrice();
            }
            userDetailsVO.setAmount(DataFormat.fenToYuan(totalAmount.toString()));
            userDetailsVO.setRankName(rank.getNam());
            if (rank.getDiscount() == 100 ){
                userDetailsVO.setDiscount("无折扣");
            }else {
                userDetailsVO.setDiscount(DataFormat.percentToDiscount(rank.getDiscount().toString()) + "折");
            }
            return JSONResult.ok(userDetailsVO);
        } else {
            return JSONResult.errorMsg("该用户不存在！");
        }
    }

    @ApiOperation(value="修改用户信息", notes="修改用户信息的接口")
    @PostMapping("/user/details")
    public JSONResult<UserDetailsVO> modifyUserDetails(@RequestBody UserDetailsVO userDetailsVO, HttpServletRequest request) throws Exception {
        Integer userId = Integer.valueOf(request.getHeader("headerUserId"));
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDetailsVO, userInfo);
        userInfo.setId(userId);
        if (userInfoService.updateUser(userInfo) == 1){
            return JSONResult.ok();
        } else {
            return JSONResult.errorMsg("修改用户信息失败！");
        }
    }



}
