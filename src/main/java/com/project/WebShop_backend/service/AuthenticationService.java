package com.project.WebShop_backend.service;

import com.project.WebShop_backend.dto.LoginDTO;
import com.project.WebShop_backend.dto.UserDTO;
import com.project.WebShop_backend.model.User;
import com.project.WebShop_backend.model.UserTokenState;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

     User register(UserDTO userDTO);

     UserTokenState login(LoginDTO userDTO);


}
