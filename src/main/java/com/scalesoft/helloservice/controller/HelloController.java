package com.scalesoft.helloservice.controller;

import com.scalesoft.helloservice.client.GreetClient;
import com.scalesoft.helloservice.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final AppProperties appProperties;
    private final GreetClient greetClient;

    @GetMapping("/hello")
    public String hello() {
        return appProperties.getMessage();
    }

    @GetMapping("/hello/message")
    public String message(){
        String greeting = greetClient.getGreeting();
        return "greeting -service : " + greeting;
    }
}
