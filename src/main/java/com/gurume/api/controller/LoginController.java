package com.gurume.api.controller;

import com.gurume.api.entity.Rank;
import com.gurume.api.entity.UserInfo;
import com.gurume.api.service.RankService;
import com.gurume.api.service.UserInfoService;
import com.gurume.api.utils.JSONResult;
import com.gurume.api.vo.UserInfoLoginVO;
import com.gurume.api.vo.UserInfoRegistVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @ClassName LoginController
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/26 10:47 AM
 * @Version 1.0
 **/
@RestController
@Api(value="用户注册登录的接口", tags= {"注册和登录"})
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RankService rankService;

    @ApiOperation(value="用户注册", notes="用户注册的接口")
    @PostMapping("/regist")
    public JSONResult<UserInfoRegistVO> regist(@RequestBody @Valid UserInfoRegistVO userInfoRegistVO) throws Exception {

        UserInfo userInfo = new UserInfo();
        if (userInfoService.findByLoginName(userInfoRegistVO.getLoginName()) != null) {
            return JSONResult.errorMsg("该用户名已存在！");
        }
        BeanUtils.copyProperties(userInfoRegistVO, userInfo);
        Rank rank = rankService.findByNum(1);// 第一等级的id
        userInfo.setRank(rank.getId());
        userInfoService.createUser(userInfo);
        userInfoRegistVO.setId(userInfo.getId().toString());
        return JSONResult.ok(userInfoRegistVO);
    }

    @ApiOperation(value="用户登录", notes="用户登录的接口")
    @PostMapping("/login")
    public JSONResult<UserInfoLoginVO> login(@RequestBody UserInfoLoginVO userInfoLoginVO) throws Exception {

        UserInfo userInfo = userInfoService.authUser(userInfoLoginVO.getLoginName(), userInfoLoginVO.getPwd());
        if (userInfo != null){
            userInfoLoginVO.setId(userInfo.getId().toString());
            return JSONResult.ok(userInfoLoginVO);
        } else {
            return JSONResult.errorMsg("用户名或密码错误！");
        }
    }



}
