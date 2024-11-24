package com.project.WebShop_backend.model;

import com.project.WebShop_backend.model.enums.TransactionStatus;
import lombok.Data;

@Data
public class BankResponse {

    private TransactionStatus transactionStatus;
    private String merchantOrderId;
    private String acquirerOrderId;
    private String acquirerTimestamp;
    private String paymentId;
}
