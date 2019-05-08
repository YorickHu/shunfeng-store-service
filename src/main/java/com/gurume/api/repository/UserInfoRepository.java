package com.gurume.api.repository;

import com.gurume.api.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findByLoginNameAndPwd(String loginName, String pwd);

    UserInfo findByLoginName(String loginName);

    UserInfo findDistinctById(Integer id);

    @Modifying
    @Transactional
    @Query("update UserInfo u set u.nickname=?1, u.age=?2 where u.id =?3")
    Integer updateUserInfo(String nickname, Integer age, Integer id);

}
