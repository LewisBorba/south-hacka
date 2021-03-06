package com.south.health.domain.user.controller.request;

import com.south.health.domain.user.model.UserType;
import io.swagger.annotations.ApiParam;

public class UserRequest {

    @ApiParam(example = "south-hacka")
    private final String username;

    @ApiParam(example = "email@email.com")
    private final String email;

    @ApiParam(example = "T3STE!")
    private final  String password;

    private final UserType userType;

    public UserRequest(String username, String email, String password, UserType userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
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
