package com.project.WebShop_backend.service.impl;

import com.project.WebShop_backend.dto.PackageDTO;
import com.project.WebShop_backend.dto.ServiceDTO;
import com.project.WebShop_backend.mapper.PackageDTOMapper;
import com.project.WebShop_backend.mapper.ServiceDTOMapper;
import com.project.WebShop_backend.model.Package;
import com.project.WebShop_backend.model.Services;
import com.project.WebShop_backend.repository.PackageRepository;
import com.project.WebShop_backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;


    @Autowired
    private ServiceDTOMapper serviceDTOMapper;

    @Autowired
    private PackageDTOMapper packageDTOMapper;

    public Package save(PackageDTO dto, List<ServiceDTO> serviceDTOS){

        List<Services> serviceEntities = serviceDTOS.stream()
                .map(serviceDTOMapper::mapServiceDTOToService)
                .collect(Collectors.toList());

        Package newPackage = new Package(dto.getName(), serviceEntities,dto.getPrice());


        return packageRepository.save(newPackage);

    }



    public List<PackageDTO> getAll() {
        List<Package> packages = packageRepository.findAll();

        return packages.stream()
                .map(packageDTOMapper::toDTO)
                .collect(Collectors.toList());
    }
}
