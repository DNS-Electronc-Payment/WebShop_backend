package com.project.WebShop_backend.service;

import com.project.WebShop_backend.dto.LoginDTO;
import com.project.WebShop_backend.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

     String register(UserDTO userDTO);

     String login(LoginDTO loginDTO);

    String findLoggedInEmail();
}
