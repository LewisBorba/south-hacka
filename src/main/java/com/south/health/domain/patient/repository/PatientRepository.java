package com.south.health.domain.patient.repository;

import com.south.health.domain.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findByUserId(Integer userId);
}
