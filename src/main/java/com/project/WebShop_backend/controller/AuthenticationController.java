package com.project.WebShop_backend.controller;

import com.project.WebShop_backend.dto.LoginDTO;
import com.project.WebShop_backend.dto.UserDTO;
import com.project.WebShop_backend.mapper.UserDTOMapper;
import com.project.WebShop_backend.model.User;
import com.project.WebShop_backend.model.UserTokenState;
import com.project.WebShop_backend.model.enums.Role;
import com.project.WebShop_backend.security.TokenUtils;
import com.project.WebShop_backend.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController {


    private final AuthenticationService authenticationService;


    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<User> register( @RequestBody UserDTO userDto){
        System.out.println("AAAA");
       User newUser= authenticationService.register(userDto);
       System.out.println(newUser);
        return  ResponseEntity.ok( authenticationService.register(userDto));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody LoginDTO authenticationRequest) {


        return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }

}