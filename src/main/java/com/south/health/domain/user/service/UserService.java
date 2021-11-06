package com.south.health.domain.user.service;

import com.south.health.domain.user.controller.request.UserLoginRequest;
import com.south.health.domain.user.model.User;
import com.south.health.domain.user.repository.UserRepository;
import com.south.health.domain.user.service.exception.UserNotAuthorizedException;
import com.south.health.domain.user.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(UserNotFoundException::new);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User login(UserLoginRequest userLoginRequest) {
        Optional<User> user = userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        return user.orElseThrow(UserNotAuthorizedException::new);

    }

}
