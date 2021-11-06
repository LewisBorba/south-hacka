package com.south.health.domain.user.service;

import com.south.health.domain.patient.model.Patient;
import com.south.health.domain.patient.service.PatientService;
import com.south.health.domain.user.model.User;
import com.south.health.domain.user.model.UserType;
import org.springframework.stereotype.Service;

@Service
public class RegistrationUserService {

    private final PatientService patientService;

    public RegistrationUserService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void register(User user) {
        if (user.getType().equals(UserType.PATIENT)) {
            patientService.save(Patient.of(user));
        }

    }
}
