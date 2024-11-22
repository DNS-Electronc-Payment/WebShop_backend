package com.project.WebShop_backend.controller;

import com.project.WebShop_backend.dto.PaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @PostMapping("/buy")
    public void  requestPayment(@RequestBody PaymentRequest request) {
        System.out.println(request);


    }
}
