package com.gurume.api.controller;

import com.gurume.api.ServerConfig;
import com.gurume.api.entity.Dish;
import com.gurume.api.entity.UserInfo;
import com.gurume.api.service.DishService;
import com.gurume.api.service.UserInfoService;
import com.gurume.api.utils.DataFormat;
import com.gurume.api.utils.JSONResult;
import com.gurume.api.vo.DishDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName DishController
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/28 10:05 PM
 * @Version 1.0
 **/
@RestController
@Api(value="菜品相关的接口", tags= {"菜品相关"})
public class DishController {

    @Autowired
    DishService dishService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ServerConfig serverConfig;

    @ApiOperation(value="菜品列表", notes="获取菜品列表")
    @GetMapping("/dish/list")
    public JSONResult<List<DishDetailVO>> getDishList(HttpServletRequest request) throws Exception {

        Integer userId = Integer.valueOf(request.getHeader("headerUserId"));

        UserInfo userInfo = userInfoService.findById(userId);

        // 获取月份
        Calendar cale = Calendar.getInstance();
        Integer month = cale.get(Calendar.MONTH) + 1;


        List<Dish> dishes = dishService.getDishList();
        List<DishDetailVO> dishDetailVOS = new ArrayList<>();
        for (Dish dish : dishes) {
            DishDetailVO dishDetailVO = new DishDetailVO();
            BeanUtils.copyProperties(dish, dishDetailVO);
            dishDetailVO.setNum("0");
            dishDetailVO.setName(dish.getNam());
            dishDetailVO.setPrice(DataFormat.fenToYuan(dish.getPrice().toString()));
            dishDetailVO.setPath(serverConfig.getUrl() + dish.getPath());
            if (dish.getCategory() == 1){
                dishDetailVO.setFlag("drink");
            } else {
                dishDetailVO.setFlag("food");
            }
            // 设置推荐
            dishDetailVO.setStatus(false);
            String[] ages = dish.getAge().split("-");
            List<String> season = Arrays.asList(dish.getSeason().split(","));
            if (userInfo.getAge() >= Integer.valueOf(ages[0]) && userInfo.getAge() <= Integer.valueOf(ages[1])) {
                dishDetailVO.setStatus(true);
            }else if (season.contains(month.toString())){
                dishDetailVO.setStatus(true);
            }
            dishDetailVOS.add(dishDetailVO);
        }
        return JSONResult.ok(dishDetailVOS);
    }
}
