package com.project.WebShop_backend.controller;

import com.project.WebShop_backend.dto.PackageDTO;
import com.project.WebShop_backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin("*")
public class PackageController {

    @Autowired
    private PackageService service;

    @GetMapping
    public ResponseEntity<List<PackageDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


}
