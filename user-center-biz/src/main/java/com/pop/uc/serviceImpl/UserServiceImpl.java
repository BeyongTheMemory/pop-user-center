package com.pop.uc.serviceImpl;


import com.google.common.base.Preconditions;
import com.pop.exception.ExceptionInfoGetter;
import com.pop.uc.dao.UserDao;
import com.pop.uc.dto.UserDto;
import com.pop.uc.entity.UserEntity;
import com.pop.uc.exception.UcBasicException;
import com.pop.uc.service.UserService;
import com.pop.uc.util.Encrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by xugang on 2016/6/4.
 *用户登录注册等基础功能
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public UserDto login(String userName, String password) {
        password = Encrypt.MD5(password);
        UserEntity userEntity = userDao.getUserByAccountAndPassword(userName, password);
        Preconditions.checkArgument(userEntity != null,"用户名或密码错误");
        UserDto user = new UserDto();
        BeanUtils.copyProperties(userEntity,user);
        return user;
    }

    public boolean regist(UserDto user){
        registCheck(user);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setPassword(Encrypt.MD5(user.getPassword()));
        userDao.save(userEntity);
        return true;
    }


    private void registCheck(UserDto userDto){
            Preconditions.checkArgument(userDao.getUserCountByAccount(userDto.getAccount())<1,"用户已存在");
    }


}
