package com.project.WebShop_backend.client;


import com.project.WebShop_backend.config.TransactionResponseHandler;
import com.project.WebShop_backend.dto.PaymentDataDTO;
import com.project.WebShop_backend.dto.PaymentRequest;
import com.project.WebShop_backend.model.BankResponse;
import com.project.WebShop_backend.model.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClient {

    @Autowired
    private RestTemplate restTemplate;



    @Autowired
    private TransactionResponseHandler transactionResponseHandler;


    public void sendPaymentRequest(PaymentRequest request){
        System.out.println("SA FRONTA ZAHTJEV"+ request);
        String url = "https://localhost:8081/payment/credit-card-payment" ;

        PaymentDataDTO paymentDataDTO= new PaymentDataDTO(request.getUserid(), request.getPrice());
        System.out.println("Sending PaymentDataDTO: " + paymentDataDTO.getPrice()+paymentDataDTO.getUserId());
        restTemplate.postForEntity(url, paymentDataDTO, Void.class);


        System.out.println("Payment request sent to PSP service.");
        System.out.println(request);
    }

    public void sendBankRequestToFront(BankResponse bankResponse){

        try {
            transactionResponseHandler.broadcastMessage(bankResponse.getTransactionStatus().toString());
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void sendTransactionResultToFront(TransactionResult result) {
        try {
            transactionResponseHandler.broadcastMessage(result.getTransactionResult().toString());
        } catch (Exception e) {
            System.out.println(e);

        }


    }
}
