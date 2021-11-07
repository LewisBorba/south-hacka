package com.south.health.domain.appointment.repository;


import com.south.health.domain.appointment.model.Appointment;
import com.south.health.domain.appointment.model.Status;
import com.south.health.domain.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByPatientAndStatus(Patient patient, Status status);
}
