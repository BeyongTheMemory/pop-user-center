package com.pop.uc.asyn;

import com.pop.uc.entity.LoginLogEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by xugang on 16/8/8.
 */
@Component
public class LogQueue {
    private LinkedTransferQueue<LoginLogEntity> logEntities;
    @PostConstruct
    public void init(){
        logEntities = new LinkedTransferQueue<>();
    }


    public void put(LoginLogEntity logEntity) {
        logEntities.put(logEntity);
    }

    public LoginLogEntity take() throws InterruptedException {
        return logEntities.take();
    }
}
