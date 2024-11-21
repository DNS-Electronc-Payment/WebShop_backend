package com.project.WebShop_backend.service.impl;

import com.project.WebShop_backend.model.Services;
import com.project.WebShop_backend.repository.ServiceRepository;
import com.project.WebShop_backend.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Services> findAllById(List<Integer> ids){
        return serviceRepository.findAllById(ids);
    }

    public Services save(Services service){
        return serviceRepository.save(service);
    }
}
