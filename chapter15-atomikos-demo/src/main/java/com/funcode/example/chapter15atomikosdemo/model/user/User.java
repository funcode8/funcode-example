package com.funcode.example.chapter15atomikosdemo.model.user;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    private Long id;

    private BigDecimal money;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}