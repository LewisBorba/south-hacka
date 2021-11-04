package com.south.health.domain.user.controller.response;

import com.south.health.domain.user.model.User;
import io.swagger.annotations.ApiModelProperty;

public class UserResponse {

    @ApiModelProperty(example = "4")
    private final Integer id;

    @ApiModelProperty(example = "south-hacka")
    private final String username;

    @ApiModelProperty(example = "email@email.com")
    private final String email;

    @ApiModelProperty(example = "T3STE!")
    private final String password;

    private UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public static UserResponse of(User user) {
        if (user == null) return null;
        return new UserResponse(user);
    }


    public Integer getId() {
        return id;
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
