package com.silver.receive;

import com.silver.common.config.DelayRabbitConfig;
import com.silver.dao.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;

import java.util.Date;

@Component
@Slf4j
public class DelayReceiver {
    /**
     * 消费消息。TODO 检查订单过期时间
     *
     * @param order
     * @param message
     * @param channel
     */
    @RabbitListener(queues = {DelayRabbitConfig.ORDER_QUEUE_NAME})
    public void orderDelayQueue(Order order, Message message, Channel channel) {
        log.info("###########################################");
        log.info("【orderDelayQueue 监听的消息】 - 【消费时间】 - [{}]- 【订单内容】 - [{}]", new Date(), order.toString());
        // 模拟订单状态，最新订单信息应从数据库获取
        if (order.getStatus() == 0) {
            order.setStatus(2);
            log.info("【该订单未支付，取消订单】" + order.toString());
        } else if (order.getStatus() == 1) {
            log.info("【该订单已完成支付】");
        } else if (order.getStatus() == 2) {
            log.info("【该订单已取消】");
        }
        log.info("###########################################");
    }
}
