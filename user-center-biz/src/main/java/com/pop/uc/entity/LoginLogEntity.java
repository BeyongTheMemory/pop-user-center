package com.pop.uc.entity;

/**
 * Created by xugang on 16/8/9.
 */
public class LoginLogEntity {
    private long userId;
    private String ip;

    public LoginLogEntity(){

    }

    public LoginLogEntity(long userId, String ip) {
        this.userId = userId;
        this.ip = ip;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
