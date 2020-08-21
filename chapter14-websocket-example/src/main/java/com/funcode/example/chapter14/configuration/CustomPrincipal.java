package com.funcode.example.chapter14.configuration;

import java.security.Principal;

/**
 * @author yaogang
 * @creat 2019-03-29 11:22
 * @contact betteryaogang@gmail.com
 */

public class CustomPrincipal implements Principal{

    public CustomPrincipal(){}

    public CustomPrincipal(String account){
        this.account = account;
    }


    private String account;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getName() {
        return this.account;
    }
}
