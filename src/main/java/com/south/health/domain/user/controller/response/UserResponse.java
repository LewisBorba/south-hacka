package com.south.health.domain.user.controller.response;

import com.south.health.domain.user.model.User;
import com.south.health.domain.user.model.UserType;
import io.swagger.annotations.ApiModelProperty;

public class UserResponse {

    @ApiModelProperty(example = "4")
    private final Integer id;

    @ApiModelProperty(example = "south-hacka")
    private final String username;

    @ApiModelProperty(example = "email@email.com")
    private final String email;


    private final UserType type;

    private UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.type = user.getType();
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

    public UserType getType() {
        return type;
    }
}
