package com.gurume.api.service.impl;

import com.gurume.api.entity.UserInfo;
import com.gurume.api.repository.UserInfoRepository;
import com.gurume.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author huyue
 * @Date 2019/4/29 9:34 AM
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public UserInfo createUser(UserInfo userInfo) {
        userInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return userInfoRepository.save(userInfo);
    }

    @Override
    public Boolean existsUser(Integer userId) {
        return userInfoRepository.existsById(userId);
    }

    @Override
    public UserInfo authUser(String loginName, String pwd) {
        return userInfoRepository.findByLoginNameAndPwd(loginName, pwd);
    }

    @Override
    public UserInfo findByLoginName(String loginName) {
        return userInfoRepository.findByLoginName(loginName);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoRepository.findDistinctById(id);
    }

    @Override
    @Modifying
    @Transactional
    public Integer updateUser(UserInfo userInfo) {
        return userInfoRepository.updateUserInfo(userInfo.getNickname(), userInfo.getAge(), userInfo.getId());
    }
}
