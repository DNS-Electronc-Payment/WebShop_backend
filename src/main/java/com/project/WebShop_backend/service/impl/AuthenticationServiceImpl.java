package com.project.WebShop_backend.service.impl;

import com.project.WebShop_backend.dto.LoginDTO;
import com.project.WebShop_backend.dto.UserDTO;
import com.project.WebShop_backend.mapper.UserDTOMapper;
import com.project.WebShop_backend.model.User;
import com.project.WebShop_backend.model.UserTokenState;
import com.project.WebShop_backend.model.enums.Role;
import com.project.WebShop_backend.security.TokenUtils;
import com.project.WebShop_backend.service.AuthenticationService;
import com.project.WebShop_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserDTOMapper userDTOMapper;

    @Autowired
    private TokenUtils tokenUtils;



    public User register(UserDTO userDTO){

        User user = userDTOMapper.mapUserDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User savedUser = userService.save(user);

        return savedUser;
    }

    public UserTokenState login(
            LoginDTO authenticationRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        //ubacuje se korisnik u trenutni security context
        SecurityContextHolder.getContext().setAuthentication(authentication);


        User user = (User) authentication.getPrincipal();
        Role role = user.getRole();
        List<String> rolesString = new ArrayList<>();


        rolesString.add(role.toString());


        String jwt = tokenUtils.generateToken(user.getUsername(), rolesString, user.getId());
        int expiresIn = tokenUtils.getExpiredIn();


        return new UserTokenState(jwt, expiresIn);
    }


}

