package com.project.WebShop_backend.controller;

import com.project.WebShop_backend.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/buy")
    public void  requestPayment(@RequestBody PaymentRequest request) {

        String url = "https://localhost:8081/payment/credit-card-payment/" + request.getPrice() + "/"+request.getUserid();

        // request to PSP service
        restTemplate.postForEntity(url, null, Void.class);

        System.out.println("Payment request sent to PSP service.");
        System.out.println(request);
    }


}
