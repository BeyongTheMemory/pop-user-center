package com.pop.uc.dao;

import com.pop.uc.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by xugang on 16/8/9.
 */
@Repository
public interface UserInfoDao {
    public void save(UserInfoEntity userInfoEntity);
    public UserInfoEntity getByUserId(@Param("userId")long uesrId);
}
