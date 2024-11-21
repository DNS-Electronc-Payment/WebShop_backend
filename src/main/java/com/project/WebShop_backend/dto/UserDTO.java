package com.project.WebShop_backend.dto;

import com.project.WebShop_backend.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserDTO {

    private Integer id;

    @NotBlank(message = "First Name should not be blank!")
    private String firstName;

    @NotBlank(message = "Last Name should not be blank!")
    private String lastName;

    @NotBlank(message = "Email should not be blank!")
    @Email
    private String email;
    private String password;

    private String role;

    public UserDTO(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
