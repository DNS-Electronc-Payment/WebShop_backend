package com.project.WebShop_backend.mapper;

import com.project.WebShop_backend.dto.PackageDTO;
import com.project.WebShop_backend.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PackageDTOMapper {

    @Autowired
    private ServiceDTOMapper serviceMapper;
    public PackageDTO toDTO(Package packageEntity) {
        PackageDTO dto = new PackageDTO();
        dto.setName(packageEntity.getName());
        dto.setServices(
                packageEntity.getServices().stream()
                        .map(serviceMapper::mapServiceToServiceDTO)
                        .collect(Collectors.toList())
        );
        return dto;
    }



}
