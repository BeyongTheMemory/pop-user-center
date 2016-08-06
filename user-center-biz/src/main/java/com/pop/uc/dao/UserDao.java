package com.pop.uc.dao;

import com.pop.uc.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by xugang on 16/7/27.
 */
@Repository
public interface UserDao {
    public int save(UserEntity userEntity);
    public int getUserCountByAccount(String account);
    public UserEntity getUserByAccountAndPassword(@Param("account")String account,@Param("password")String password);
}
