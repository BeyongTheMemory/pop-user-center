package com.pop.uc.dto;

import com.pop.security.Account;

import java.io.Serializable;

/**
 * Created by xugang on 2016/6/4.
 */
public class UserDto extends Account implements Serializable{
    private long id;
    private String account;
    private String password;
    private String name;
    private String headUrl;
    private String introduction;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHeadUrl() {
        return headUrl;
    }
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
