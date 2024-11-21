package com.project.WebShop_backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTokenState {
    private String token;
    private long expiresIn;

    public UserTokenState(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}