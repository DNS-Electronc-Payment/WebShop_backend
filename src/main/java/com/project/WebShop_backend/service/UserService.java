package com.project.WebShop_backend.service;

import com.project.WebShop_backend.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public Optional<User> findByEmail(String email);
    public  User save(User user);

    boolean existsByEmail(String email);
}
