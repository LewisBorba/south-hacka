package com.south.health.domain.user.service;

import com.south.health.domain.medic.model.Medic;
import com.south.health.domain.medic.repository.MedicRepository;
import com.south.health.domain.patient.model.Patient;
import com.south.health.domain.patient.repository.PatientRepository;
import com.south.health.domain.user.controller.request.UserLoginRequest;
import com.south.health.domain.user.model.User;
import com.south.health.domain.user.model.UserType;
import com.south.health.domain.user.repository.UserRepository;
import com.south.health.domain.user.service.exception.UserNotAuthorizedException;
import com.south.health.domain.user.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final MedicRepository medicRepository;

    public UserService(UserRepository userRepository, PatientRepository patientRepository, MedicRepository medicRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.medicRepository = medicRepository;
    }

    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(UserNotFoundException::new);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword())
                .orElseThrow(UserNotAuthorizedException::new);
        if (user.getType().equals(UserType.PATIENT)) {
            Patient patient = patientRepository.findByUserId(user.getId());
            user.setId(patient.getId());
        }
        if (user.getType().equals(UserType.MEDIC)) {
            Medic medic = medicRepository.findByUserId(user.getId());
            user.setId(medic.getId());
        }
        return user;
    }

}
