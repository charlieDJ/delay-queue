package com.silver.send;

import com.silver.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRabbitMQ extends ApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void testRabbit() {
        sender.send("hello, rabbit~");
    }

    @Test
    public void testTopic(){
        sender.sendTopic("hello,topic rabbit~");
    }

    @Test
    public void testFanout() {
        sender.sendFanout("荣耀之光");
    }
}
