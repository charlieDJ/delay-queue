package com.silver.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;

    public void send(String msg) {
        template.convertAndSend("queue", msg);
    }

    public void sendTopic(String msg) {
        template.convertAndSend("exchange", "topic.message", msg);
    }

    public void sendFanout(String msg) {
        template.convertAndSend("fanoutExchange", "", msg);// 参数2将被忽略
    }
}
