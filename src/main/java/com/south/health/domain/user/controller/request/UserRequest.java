package com.south.health.domain.user.controller.request;

import com.south.health.domain.user.model.User;
import io.swagger.annotations.ApiParam;

public class UserRequest {

    @ApiParam(example = "south-hacka")
    private final String username;

    @ApiParam(example = "email@email.com")
    private final String email;

    @ApiParam(example = "T3STE!")
    private final  String password;

    public UserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User toUser() {
        return new User(this.username, this.email, this.password);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
