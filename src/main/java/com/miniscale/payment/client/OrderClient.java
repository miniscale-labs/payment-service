package com.miniscale.payment.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OrderClient {

    private final WebClient client = WebClient.create("http://order-service:8081");

    public String fetchOrder(String id) {
        return client.get()
                .uri("/orders/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
