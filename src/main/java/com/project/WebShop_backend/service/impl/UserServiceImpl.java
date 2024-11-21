package com.project.WebShop_backend.service.impl;

import com.project.WebShop_backend.model.User;
import com.project.WebShop_backend.repository.UserRepository;
import com.project.WebShop_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public  User save(User user){
        try {
            return userRepository.save(user);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error while saving user " + e.getMessage(), e);
        }
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
