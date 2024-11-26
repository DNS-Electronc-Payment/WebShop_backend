package com.project.WebShop_backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequest {

    private long userid;
    private Integer packageid;
    private Double price;
    private String type;
}
