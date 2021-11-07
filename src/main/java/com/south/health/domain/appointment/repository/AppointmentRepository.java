package com.south.health.domain.appointment.repository;


import com.south.health.domain.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
