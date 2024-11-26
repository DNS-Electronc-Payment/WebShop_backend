package com.project.WebShop_backend.client;


import com.project.WebShop_backend.config.ErrorSocket;
import com.project.WebShop_backend.config.FailedSocket;
import com.project.WebShop_backend.config.SuccessSocket;
import com.project.WebShop_backend.dto.PaymentDataDTO;
import com.project.WebShop_backend.dto.PaymentRequest;
import com.project.WebShop_backend.model.BankResponse;
import com.project.WebShop_backend.model.TransactionResult;
import com.project.WebShop_backend.model.enums.TransactionStatus;
import org.apache.catalina.startup.FailedContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClient {

    @Autowired
    private RestTemplate restTemplate;



    @Autowired
    private SuccessSocket successSocket;

    @Autowired
    private FailedSocket failedSocket;

    @Autowired
    private ErrorSocket errorSocket;


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
        TransactionStatus status = bankResponse.getTransactionStatus();

        switch (status) {
            case SUCCESS:
                sendSuccessUrl("");
                break;
            case ERROR:
                sendErrorUrl("");
                break;
            case FAIL:
                sendFailedUrl("");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }


    }

    public void sendTransactionResultToFront(TransactionResult result) {

        TransactionStatus status = result.getTransactionResult();
        switch (status) {
            case SUCCESS:
                sendSuccessUrl("");
                break;
            case ERROR:
                sendErrorUrl("");
                break;
            case FAIL:
                sendFailedUrl("");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }


    }

    public void sendErrorUrl(String url){
        try {
            errorSocket.broadcastMessage(url);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void sendFailedUrl(String url){
        try {
            failedSocket.broadcastMessage(url);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void sendSuccessUrl(String url){
        try {
            successSocket.broadcastMessage(url);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
