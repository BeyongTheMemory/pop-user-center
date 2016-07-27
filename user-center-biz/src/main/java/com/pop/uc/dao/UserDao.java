package com.pop.uc.dao;

import com.pop.uc.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by xugang on 16/7/27.
 */
@Repository
public interface UserDao {
    public int save(UserEntity userEntity);
}
