package com.pop.uc.dao;

import com.pop.uc.entity.UserMobileEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xugang on 16/10/18.
 */
public interface UserMobileDao {
    void save(UserMobileEntity userMobileEntity);
    UserMobileEntity getByUserId(@Param("userId")long userId);
}
