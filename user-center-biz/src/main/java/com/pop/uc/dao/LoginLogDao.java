package com.pop.uc.dao;

import com.pop.uc.entity.LoginLogEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by xugang on 16/8/9.
 */
@Repository
public interface LoginLogDao {
    public void save(LoginLogEntity loginLogEntity);

}
