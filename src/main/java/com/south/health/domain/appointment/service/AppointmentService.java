package com.south.health.domain.appointment.service;

import com.south.health.domain.appointment.controller.request.AppointmentRequest;
import com.south.health.domain.appointment.model.Appointment;
import com.south.health.domain.appointment.repository.AppointmentRepository;
import com.south.health.domain.patient.model.Patient;
import com.south.health.domain.patient.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(PatientService patientService, AppointmentRepository appointmentRepository) {
        this.patientService = patientService;
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment scheduleAppointment(AppointmentRequest appointmentRequest) {
        Patient patient = patientService.findById(appointmentRequest.getIdPatient());
        return appointmentRepository.save(Appointment.of(appointmentRequest, patient));
    }
}
