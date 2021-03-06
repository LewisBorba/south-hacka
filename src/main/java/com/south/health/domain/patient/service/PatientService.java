package com.south.health.domain.patient.service;

import com.south.health.domain.patient.controller.request.PatientRequest;
import com.south.health.domain.patient.model.Patient;
import com.south.health.domain.patient.repository.PatientRepository;
import com.south.health.domain.user.model.User;
import com.south.health.domain.user.service.UserService;
import com.south.health.domain.user.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserService userService;

    public PatientService(PatientRepository patientRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userService = userService;
    }

    public void save(Patient patient) {
        patientRepository.save(patient);

    }

    public Patient registerPatient(PatientRequest patientRequest) {
        User user = userService.save(User.of(patientRequest));
        return patientRepository.save(Patient.of(user));
    }

    public Patient findById(Integer idPatient) {
        Optional<Patient> patient = patientRepository.findById(idPatient);
        return patient.orElseThrow(UserNotFoundException::new);
    }

    public Patient findByUserId(Integer userId) {
        return patientRepository.findByUserId(userId);
    }
}
