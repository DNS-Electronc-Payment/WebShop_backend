package com.project.WebShop_backend.dto;

import com.project.WebShop_backend.model.enums.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceDTO {

    private Integer id;
    private String name;
    private String description;
    private String type;
}
