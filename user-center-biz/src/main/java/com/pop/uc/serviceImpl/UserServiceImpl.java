package com.pop.uc.serviceImpl;


import com.google.common.base.Preconditions;
import com.pop.exception.ExceptionInfoGetter;
import com.pop.uc.asyn.LogQueue;
import com.pop.uc.asyn.MobileQueue;
import com.pop.uc.dao.UserDao;
import com.pop.uc.dao.UserInfoDao;
import com.pop.uc.dto.LoginDto;
import com.pop.uc.dto.UserDto;
import com.pop.uc.dto.UserInfoDto;
import com.pop.uc.entity.LoginLogEntity;
import com.pop.uc.entity.UserEntity;
import com.pop.uc.entity.UserInfoEntity;
import com.pop.uc.entity.UserMobileEntity;
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
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private LogQueue logQueue;
    @Autowired
    private MobileQueue mobileQueue;

    public UserDto login(LoginDto loginDto) {
        String password = Encrypt.MD5(loginDto.getPassword());
        UserEntity userEntity = userDao.getUserByAccountAndPassword(loginDto.getAccount(), password);
        Preconditions.checkArgument(userEntity != null, "用户名或密码错误");
        UserDto user = new UserDto();
        BeanUtils.copyProperties(userEntity, user);
        logQueue.put(new LoginLogEntity(user.getId(), loginDto.getIp()));//记录登录日志
        if(!StringUtils.isEmpty(loginDto.getClintId())) {
            mobileQueue.put(new UserMobileEntity(user.getId(), loginDto.getClintId(), loginDto.getClientType()));//记录设备标示{
        }
        return user;
    }

    public boolean regist(UserDto user){
        registCheck(user);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setPassword(Encrypt.MD5(user.getPassword()));
        userDao.save(userEntity);
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(userEntity.getId());
        userInfoDao.save(userInfoEntity);
        return true;
    }

    public void updatePwd(String account, String oldPassword,String newPassword){
        int reult = userDao.updatePwd(account,Encrypt.MD5(oldPassword),Encrypt.MD5(newPassword));
        Preconditions.checkArgument(reult > 0, "原密码错误");
    }

    public UserInfoDto getUserInfoByUserId(long userId){
        UserInfoEntity userInfoEntity = userInfoDao.getByUserId(userId);
        UserInfoDto userInfoDto = new UserInfoDto();
        if(userInfoEntity != null){
            BeanUtils.copyProperties(userInfoEntity,userInfoDto);
        }
        return userInfoDto;
    }

    public void update(UserDto user){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userDao.update(userEntity);
    }

    public void updateUserInfo(UserInfoDto userInfoDto){
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDto,userInfoEntity);
        userInfoDao.update(userInfoEntity);

    }


    private void registCheck(UserDto userDto){
            Preconditions.checkArgument(userDao.getUserCountByAccount(userDto.getAccount()) < 1, "用户已存在");
    }


}
