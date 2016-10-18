package com.pop.uc.asyn;

import com.pop.uc.entity.LoginLogEntity;
import com.pop.uc.entity.UserMobileEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by xugang on 16/8/8.
 */
@Component
public class MobileQueue {
    private LinkedTransferQueue<UserMobileEntity> userMobileEntities;
    @PostConstruct
    public void init(){
        userMobileEntities = new LinkedTransferQueue<>();
    }


    public void put(UserMobileEntity userMobileEntity) {
        userMobileEntities.put(userMobileEntity);
    }

    public UserMobileEntity take() throws InterruptedException {
        return userMobileEntities.take();
    }
}
