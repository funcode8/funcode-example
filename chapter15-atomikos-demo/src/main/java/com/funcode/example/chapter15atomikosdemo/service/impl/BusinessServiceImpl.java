package com.funcode.example.chapter15atomikosdemo.service.impl;

import com.funcode.example.chapter15atomikosdemo.mapper.order.OrdersMapper;
import com.funcode.example.chapter15atomikosdemo.mapper.user.UserMapper;
import com.funcode.example.chapter15atomikosdemo.model.order.Orders;
import com.funcode.example.chapter15atomikosdemo.model.user.User;
import com.funcode.example.chapter15atomikosdemo.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 萌新程序员成长日记
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private static Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    private OrdersMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submitOrder() {
        User user = new User();
        user.setId(1L);
        user.setMoney(new BigDecimal(800));
        userMapper.updateByPrimaryKeySelective(user);

        Orders order = new Orders();
        order.setCreateTime(new Date());
        order.setUserId(1L);
        order.setStatus((byte)0);
        order.setTotal(new BigDecimal(200));
        orderMapper.insertSelective(order);

        int s = Integer.parseInt("s");
    }

    @Override
    @Transactional(transactionManager = "orderTransactionManager", rollbackFor = Exception.class)
    public void submitOrder2() {
        User user = new User();
        user.setMoney(new BigDecimal(500));
        userMapper.insertSelective(user);

        User user2 = new User();
        user2.setId(1L);
        user2.setMoney(new BigDecimal(500));
        userMapper.insertSelective(user2);
    }
}
