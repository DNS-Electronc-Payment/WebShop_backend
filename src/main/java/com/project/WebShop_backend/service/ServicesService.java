package com.project.WebShop_backend.service;

import com.project.WebShop_backend.dto.ServiceDTO;
import com.project.WebShop_backend.model.Services;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicesService {
     List<Services> findAllById(List<Integer> ids);


      Services save(Services service);

      List<ServiceDTO> getAll();
}
