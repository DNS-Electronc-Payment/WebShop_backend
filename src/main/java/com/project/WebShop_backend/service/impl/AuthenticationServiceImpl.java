package com.project.WebShop_backend.service.impl;

import com.project.WebShop_backend.dto.LoginDTO;
import com.project.WebShop_backend.dto.UserDTO;
import com.project.WebShop_backend.mapper.UserDTOMapper;
import com.project.WebShop_backend.model.User;
import com.project.WebShop_backend.service.AuthenticationService;
import com.project.WebShop_backend.service.JwtService;
import com.project.WebShop_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final UserDTOMapper userDTOMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public String register(UserDTO userDTO){
        if (userService.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = userDTOMapper.mapUserDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User savedUser = userService.save(user);
        var jwt = jwtService.generateToken(savedUser);
        return jwt;
    }

    public String login(LoginDTO loginDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );
        var foundUser= userService.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new NoSuchElementException("User with email " + loginDTO.getEmail() + " not found"));;
        var jwt= jwtService.generateToken(foundUser);
        return jwt;

    }

    public String findLoggedInEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }

        return null;
    }
}

