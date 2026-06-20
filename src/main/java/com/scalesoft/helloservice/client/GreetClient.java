package com.scalesoft.helloservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GreetClient {

    @Value("${greet.service.url}")
    private String greetServiceUrl;

    private final WebClient webClient;

    @CircuitBreaker(
            name = "greetService",
            fallbackMethod = "fallbackGreeting"
    )
    public String getGreeting() {
        return webClient
                .get()
                .uri( greetServiceUrl+ "/greet")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String fallbackGreeting(Exception ex) {
        return "Greet Service Currently Unavailable";
    }

}
