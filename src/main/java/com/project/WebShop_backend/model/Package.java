package com.project.WebShop_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    @ManyToMany
    @JoinTable(
            name = "package_service",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Services> services;

    public Package(String name, List<Services> services,Double price) {
        this.name = name;
        this.services = services;
        this.price=price;
    }
}
