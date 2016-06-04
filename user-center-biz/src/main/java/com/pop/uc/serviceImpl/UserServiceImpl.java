package com.pop.uc.serviceImpl;


import com.pop.uc.dto.User;
import com.pop.uc.service.UserService;

/**
 * Created by xugang on 2016/6/4.
 *用户登录注册等基础功能
 */
public class UserServiceImpl implements UserService {

    @Override
    public User login(String userName, String password) {
        User user = new User();
        user.setUserName("root");
        user.setPassword("root");
        return user;
    }
}
