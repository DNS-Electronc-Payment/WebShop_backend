package com.project.WebShop_backend.repository;

import com.project.WebShop_backend.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package,Integer> {
}
