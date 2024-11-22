package com.project.WebShop_backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequest {

    private Integer userid;
    private Integer packageid;
    private Integer price;
    private String type;
}
