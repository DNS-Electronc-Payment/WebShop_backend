package com.project.WebShop_backend.mapper;

import com.project.WebShop_backend.dto.ServiceDTO;
import com.project.WebShop_backend.model.Services;
import com.project.WebShop_backend.model.enums.ServiceType;
import org.springframework.stereotype.Service;

@Service
public class ServiceDTOMapper {

    public ServiceDTO mapServiceToServiceDTO(Services service) {
        return new ServiceDTO(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getType().toString(),
                service.getPrice()
        );
    }

    public Services mapServiceDTOToService(ServiceDTO dto){
        return new Services(
                dto.getName(),
                dto.getDescription(),
                ServiceType.valueOf(dto.getType().toUpperCase()),
                dto.getPrice()
        );
    }
}
