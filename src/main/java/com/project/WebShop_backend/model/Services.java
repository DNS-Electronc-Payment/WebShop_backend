package com.project.WebShop_backend.model;

import com.project.WebShop_backend.model.enums.ServiceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private ServiceType type;
    private Double price;
    @ManyToMany(mappedBy = "services")
    private List<Package> packages;

    public Services(String name, String description, ServiceType type,Double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price=price;
    }
}
