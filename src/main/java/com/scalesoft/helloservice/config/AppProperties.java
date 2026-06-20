package com.scalesoft.helloservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${application.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
