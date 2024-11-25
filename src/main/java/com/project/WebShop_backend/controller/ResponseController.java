package com.project.WebShop_backend.controller;


import com.project.WebShop_backend.client.APIClient;
import com.project.WebShop_backend.model.BankResponse;
import com.project.WebShop_backend.model.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/response")
@CrossOrigin("*")
public class ResponseController {

    @Autowired
    private APIClient apiClient;



    @PostMapping("/bankResponse")
    public void bankResponse(@RequestBody   BankResponse bankResponse){
        apiClient.sendBankRequestToFront(bankResponse);
    }

    @PostMapping("/transactionResult")
    public void transactionResult(@RequestBody TransactionResult transactionResult){
            apiClient.sendTransactionResultToFront(transactionResult);

    }






}
