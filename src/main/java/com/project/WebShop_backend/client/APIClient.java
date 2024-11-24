package com.project.WebShop_backend.client;


import com.project.WebShop_backend.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClient {

    @Autowired
    private RestTemplate restTemplate;

    public void sendPaymentRequest(PaymentRequest request){
        String url = "https://localhost:8081/payment/credit-card-payment/" + request.getPrice() + "/"+request.getUserid();

        restTemplate.postForEntity(url, null, Void.class);

        System.out.println("Payment request sent to PSP service.");
        System.out.println(request);
    }
}
