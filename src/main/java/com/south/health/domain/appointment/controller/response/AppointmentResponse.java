package com.south.health.domain.appointment.controller.response;

import com.south.health.domain.appointment.model.Appointment;

public class AppointmentResponse {

    private final Integer id;
    private final Integer patientId;
    private final String appointmentType;
    private final String availableHours;
    private final String patientName;

    private AppointmentResponse(Integer id, Integer patientId, String appointmentType, String availableHours, String patientName) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentType = appointmentType;
        this.availableHours = availableHours;
        this.patientName = patientName;
    }

    public static AppointmentResponse of(Appointment appointment) {
        if (appointment == null) return null;
        return new AppointmentResponse(appointment.getId(), appointment.getPatient().getId(),
                appointment.getAppointmentType(), appointment.getAvailableHours(), appointment.getPatient().getName());
    }

    public Integer getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getAvailableHours() {
        return availableHours;
    }
}
