package com.project.WebShop_backend.mapper;

import com.project.WebShop_backend.dto.UserDTO;
import com.project.WebShop_backend.model.User;
import com.project.WebShop_backend.model.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper {


    public UserDTO mapUserToUserDTO(User user) {
        return new UserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().toString()

        );
    }

    public User mapUserDTOToUser(UserDTO userDTO) {



        return new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                Role.valueOf(userDTO.getRole().toUpperCase())
        );
    }



}

