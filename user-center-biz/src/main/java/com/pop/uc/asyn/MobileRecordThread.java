package com.pop.uc.asyn;

import com.pop.uc.dao.UserMobileDao;
import com.pop.uc.entity.LoginLogEntity;
import com.pop.uc.entity.UserMobileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by xugang on 16/8/8.
 */
@Component
public class MobileRecordThread implements Runnable {
    private static final Logger errorLog = LoggerFactory.getLogger(MobileRecordThread.class);
    @Autowired
    UserMobileDao userMobileDao;
    @Autowired
    private MobileQueue mobileQueueQueue;

    @PostConstruct
    public void init() throws InterruptedException {
        Thread thread = new Thread(this, "mobileRecordThread");
        thread.start();
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                UserMobileEntity userMobileEntity = mobileQueueQueue.take();
                userMobileDao.save(userMobileEntity);
            } catch (InterruptedException e1) {
                errorLog.error("mobileRecordThread InterruptedException", e1);
            } catch (Exception e2) {
                errorLog.error("mobileRecordThread unexpect error", e2);
            }
        }

    }
}
