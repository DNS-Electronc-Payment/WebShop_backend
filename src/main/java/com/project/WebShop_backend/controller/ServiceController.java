package com.project.WebShop_backend.controller;

import com.project.WebShop_backend.dto.ServiceDTO;
import com.project.WebShop_backend.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin("*")
public class ServiceController {

    @Autowired
    private ServicesService service;


    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getAll(){
        return  ResponseEntity.ok(service.getAll());
    }
}
