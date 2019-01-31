package com.silver.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class TopicReceive {

    @RabbitListener(queues = "topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        log.info("message:" + str);
    }

    @RabbitListener(queues = "topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        log.info("messages:" + str);
    }

}
