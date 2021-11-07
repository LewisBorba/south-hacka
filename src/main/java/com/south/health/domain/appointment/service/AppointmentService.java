package com.south.health.domain.appointment.service;

import com.south.health.domain.appointment.controller.request.AppointmentAcceptRequest;
import com.south.health.domain.appointment.controller.request.AppointmentRequest;
import com.south.health.domain.appointment.model.Appointment;
import com.south.health.domain.appointment.model.Status;
import com.south.health.domain.appointment.repository.AppointmentRepository;
import com.south.health.domain.medic.model.Medic;
import com.south.health.domain.medic.service.MedicService;
import com.south.health.domain.patient.model.Patient;
import com.south.health.domain.patient.service.PatientService;
import com.south.health.domain.user.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;
    private final MedicService medicService;

    public AppointmentService(PatientService patientService, AppointmentRepository appointmentRepository, MedicService medicService) {
        this.patientService = patientService;
        this.appointmentRepository = appointmentRepository;
        this.medicService = medicService;
    }

    public Appointment scheduleAppointment(AppointmentRequest appointmentRequest) {
        Patient patient = patientService.findById(appointmentRequest.getIdPatient());
        return appointmentRepository.save(Appointment.of(appointmentRequest, patient));
    }

    private Appointment findById(Integer appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        return appointment.orElseThrow(UserNotFoundException::new);
    }

    public Appointment acceptAppointment(AppointmentAcceptRequest appointmentAcceptRequest, Integer appointmentId) {
        Appointment appointment = this.findById(appointmentId);
        Medic medic = medicService.findById(appointmentAcceptRequest.getMedicId());
        appointment.updateBy(appointmentAcceptRequest, medic);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getRequestedAppointments(Integer patiendId) {
        Patient patient = patientService.findById(patiendId);
        return appointmentRepository.findByPatientAndStatus(patient, Status.REQUESTED);
    }

    public List<Appointment> getAcceptedAppointments(Integer patiendId) {
        Patient patient = patientService.findById(patiendId);
        return appointmentRepository.findByPatientAndStatus(patient, Status.ACCEPTED);
    }

    public List<Appointment> getScheduledAppointments(Integer medicId) {
        Medic medic = medicService.findById(medicId);
        return appointmentRepository.findByMedicAndStatus(medic, Status.ACCEPTED);
    }


    public List<Appointment> getAvailableAppointments(String type) {
        return appointmentRepository.findByAppointmentTypeAndStatus(type, Status.REQUESTED);
    }

    public Appointment cancelAppointment(Integer appointmentId) {
        Appointment appointment = this.findById(appointmentId);
        appointment.cancel();
        return appointmentRepository.save(appointment);
    }
}
