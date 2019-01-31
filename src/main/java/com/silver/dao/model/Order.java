package com.silver.dao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 订单状态 0：未支付，1：已支付，2：订单已取消
     */
    private Integer status;
    /**
     * 订单名称
     */
    private String orderName;
    /**
     * 订单过期时间。Long类型时间戳数字。
     * 如果修改了过期时间，receiver消费消息应当判断过期时间，过期时间大于消费时间应重新入队
     */
    private Long expireTime;
}
