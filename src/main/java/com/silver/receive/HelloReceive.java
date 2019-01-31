package com.silver.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloReceive {

    @RabbitListener(queues = "queue")    //监听器监听指定的Queue
    public void process(String str) {
        log.info("Receive:" + str);
    }

}
