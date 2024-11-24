package com.project.WebShop_backend.model;

import com.project.WebShop_backend.model.enums.TransactionStatus;

public class TransactionResult {
    private TransactionStatus transactionResult;
    private String acquirerOrderId;
    private String acquirerTimestamp;
    private String issuerOrderId;
    private String issuerTimestamp;
}
