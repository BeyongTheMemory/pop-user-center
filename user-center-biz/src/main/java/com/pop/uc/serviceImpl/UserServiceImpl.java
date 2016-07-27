package com.pop.uc.serviceImpl;


import com.pop.uc.dao.UserDao;
import com.pop.uc.dto.UserDto;
import com.pop.uc.entity.UserEntity;
import com.pop.uc.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xugang on 2016/6/4.
 *用户登录注册等基础功能
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDto login(String userName, String password) {
        UserDto user = new UserDto();
        return user;
    }

    @Override
    public boolean regist(UserDto user){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userDao.save(userEntity);
        return true;
    }


}
