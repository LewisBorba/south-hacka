package com.south.health.domain.user.controller;

import com.south.health.domain.user.controller.request.UserLoginRequest;
import com.south.health.domain.user.controller.request.UserRequest;
import com.south.health.domain.user.controller.response.UserResponse;
import com.south.health.domain.user.model.User;
import com.south.health.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/login")
    @ApiOperation(value = "Endpoint that sign in user")
    public UserResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        User user = userService.login(userLoginRequest);
        return UserResponse.of(user);
    }

}
