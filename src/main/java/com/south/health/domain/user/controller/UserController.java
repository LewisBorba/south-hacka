package com.south.health.domain.user.controller;

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

    @GetMapping
    @ApiOperation(value = "Get user by id")
    public UserResponse findUserById(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        return UserResponse.of(user);
    }

    @PostMapping
    @ApiOperation(value= "Create user")
    public UserResponse save(@RequestBody UserRequest userRequest) {
        User user = userService.save(userRequest.toUser());
        return UserResponse.of(user);
    }

}
