package com.pop.uc.entity;

/**
 * Created by xugang on 16/10/18.
 */
public class UserMobileEntity {
    private long userId;
    private String clientId;
    private int clientType;

    public UserMobileEntity(long userId, String clientId, int clientType) {
        this.userId = userId;
        this.clientId = clientId;
        this.clientType = clientType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
}
