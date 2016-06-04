package com.pop.uc.dto;

import java.io.Serializable;

/**
 * Created by xugang on 2016/6/4.
 */
public class User implements Serializable{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
