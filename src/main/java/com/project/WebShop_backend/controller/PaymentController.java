package com.project.WebShop_backend.controller;

import com.project.WebShop_backend.client.APIClient;
import com.project.WebShop_backend.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private APIClient apiClient;

    @PostMapping("/buy")
    public void  requestPayment(@RequestBody PaymentRequest request) {
        apiClient.sendPaymentRequest(request);

    }


}
