package com.silver.controller;

import com.silver.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Autowired
    private SimpleService simpleService;

    @GetMapping("/send-delay")
    public Object sendDelay() {
        return simpleService.sendDelay();
    }

}
