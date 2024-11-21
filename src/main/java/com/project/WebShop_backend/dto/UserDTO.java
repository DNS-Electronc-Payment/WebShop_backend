package com.project.WebShop_backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserDTO {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;
    private String password;

    private String role;

    public UserDTO(String firstName, String lastName, String email, String password, String role) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
