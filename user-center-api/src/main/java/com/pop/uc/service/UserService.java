package com.pop.uc.service;

import com.pop.uc.dto.User;

/**
 * Created by xugang on 2016/6/4.
 *用户登录注册等基础功能
 */
public interface UserService {
    public User login(String userName,String password);
}
