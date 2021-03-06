package com.south.health.domain.medic.service;

import com.south.health.domain.medic.controller.request.MedicRequest;
import com.south.health.domain.medic.model.Medic;
import com.south.health.domain.medic.repository.MedicRepository;
import com.south.health.domain.user.model.User;
import com.south.health.domain.user.service.UserService;
import com.south.health.domain.user.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicService {
    private final UserService userService;
    private final MedicRepository medicRepository;

    public MedicService(UserService userService, MedicRepository medicRepository) {
        this.userService = userService;
        this.medicRepository = medicRepository;
    }


    public Medic registerMedic(MedicRequest medicRequest) {
        User user = userService.save(User.of(medicRequest));
        return medicRepository.save(Medic.of(user, medicRequest));

    }

    public Medic findById(Integer medicId) {
        Optional<Medic> medic = medicRepository.findById(medicId);
        return medic.orElseThrow(UserNotFoundException::new);
    }
}
