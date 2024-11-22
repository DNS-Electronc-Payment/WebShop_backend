package com.project.WebShop_backend.service.impl;

import com.project.WebShop_backend.dto.ServiceDTO;
import com.project.WebShop_backend.mapper.ServiceDTOMapper;
import com.project.WebShop_backend.model.Services;
import com.project.WebShop_backend.repository.ServiceRepository;
import com.project.WebShop_backend.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceDTOMapper mapper;

    public List<Services> findAllById(List<Integer> ids){
        return serviceRepository.findAllById(ids);
    }

    public Services save(Services service){
        return serviceRepository.save(service);
    }

    public List<ServiceDTO> getAll() {
        List<Services> services= serviceRepository.findAll();
        return services.stream()
                .map(mapper::mapServiceToServiceDTO)
                .collect(Collectors.toList());
    }



}
