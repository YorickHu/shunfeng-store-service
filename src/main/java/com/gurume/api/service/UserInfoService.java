package com.gurume.api.service;

import com.gurume.api.entity.UserInfo;

public interface UserInfoService {

    public UserInfo createUser(UserInfo userInfo);

    public Boolean existsUser(Integer userId);

    public UserInfo authUser(String loginName, String pwd);

    public UserInfo findByLoginName(String loginName);

    public UserInfo findById(Integer id);

    public Integer updateUser(UserInfo userInfo);

}
