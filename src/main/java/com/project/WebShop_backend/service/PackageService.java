package com.project.WebShop_backend.service;

import com.project.WebShop_backend.dto.PackageDTO;
import com.project.WebShop_backend.dto.ServiceDTO;
import com.project.WebShop_backend.model.Package;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackageService {

    Package save(PackageDTO dto, List<ServiceDTO> serviceDTOS);


     List<PackageDTO> getAll();

}
