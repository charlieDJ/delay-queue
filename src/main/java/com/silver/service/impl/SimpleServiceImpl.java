package com.silver.service.impl;

import com.silver.dao.model.Order;
import com.silver.send.DelaySender;
import com.silver.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    private DelaySender delaySender;

    @Override
    public Object sendDelay() {
        Order order1 = new Order();
        order1.setStatus(0)
                .setOrderId("123456")
                .setOrderName("小米7")
                .setExpireTime(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1L));
        Order order2 = new Order();
        order2.setStatus(1)
                .setOrderId("456789")
                .setOrderName("小米MIX")
                .setExpireTime(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1L));
        delaySender.sendDelay(order1);
        delaySender.sendDelay(order2);
        return "ok";
    }
}
