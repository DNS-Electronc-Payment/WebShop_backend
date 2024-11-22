package com.project.WebShop_backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class PackageDTO {
    private Integer id;
    private String name;
    private List<ServiceDTO> services;

    private Double price;

}
