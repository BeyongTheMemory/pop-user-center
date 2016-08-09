package com.pop.uc.asyn;

import com.pop.uc.dao.LoginLogDao;
import com.pop.uc.entity.LoginLogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by xugang on 16/8/8.
 */
@Component
public class LogSendThread implements Runnable {
    private static final Logger errorLog = LoggerFactory.getLogger(LogSendThread.class);
    @Autowired
    LoginLogDao loginLogDao;
    @Autowired
    private LogQueue logQueue;

    @PostConstruct
    public void init() throws InterruptedException {
        Thread thread = new Thread(this, "logSendThread");
        thread.start();
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                LoginLogEntity logEntity = logQueue.take();
                loginLogDao.save(logEntity);
            } catch (InterruptedException e1) {
                errorLog.error("logSendThread InterruptedException", e1);
            } catch (Exception e2) {
                errorLog.error("logSendThread unexpect error", e2);
            }
        }

    }
}
