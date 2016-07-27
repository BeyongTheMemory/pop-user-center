package com.pop.uc.service;

import com.pop.uc.dto.UserDto;

/**
 * Created by xugang on 2016/6/4.
 *用户登录注册等基础功能
 */
public interface UserService {
    public UserDto login(String userName,String password);
    public boolean regist(UserDto user);
}
