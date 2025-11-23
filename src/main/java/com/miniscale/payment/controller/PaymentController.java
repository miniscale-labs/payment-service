package com.miniscale.payment.controller;

import com.miniscale.payment.client.OrderClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/payments")
public class PaymentController {

    private final OrderClient orderClient;

    public PaymentController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @PostMapping("/{id}")
    public String pay(@PathVariable String id) {
        String order = orderClient.fetchOrder(id);
        return "Payment processed for " + order;
    }
}
