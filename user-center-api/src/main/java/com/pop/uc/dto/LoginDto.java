package com.pop.uc.dto;

import java.io.Serializable;

/**
 * Created by xugang on 16/10/18.
 */
public class LoginDto implements Serializable {
    private String account;
    private String password;
    private String ip;
    private String clintId;
    private int clientType;//1:android,2:ios

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClintId() {
        return clintId;
    }

    public void setClintId(String clintId) {
        this.clintId = clintId;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
}
