package com.pop.uc.service;

import com.pop.uc.dto.LoginDto;
import com.pop.uc.dto.UserDto;
import com.pop.uc.dto.UserInfoDto;

/**
 * Created by xugang on 2016/6/4.
 * 用户登录注册等基础功能
 */
public interface UserService {
    UserDto login(LoginDto loginDto);

    boolean regist(UserDto user);

    UserInfoDto getUserInfoByUserId(long userId);

    void update(UserDto user);

    void updateUserInfo(UserInfoDto userInfoDto);

    void updatePwd(String account, String oldPassword, String newPassword);
}
