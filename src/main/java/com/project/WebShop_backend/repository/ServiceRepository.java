package com.project.WebShop_backend.repository;

import com.project.WebShop_backend.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Integer> {
}
