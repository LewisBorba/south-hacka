package com.south.health.domain.appointment.controller.response;

import com.south.health.domain.appointment.model.Appointment;

public class AppointmentAcceptResponse {

    private final Integer id;
    private final Integer patientId;
    private final String appointmentType;
    private final String availableHours;
    private final String patientName;
    private final String medicName;
    private final Integer medicId;
    private final String link;
    private final String acceptedHour;

    private AppointmentAcceptResponse(Appointment appointment) {
        this.id = appointment.getId();
        this.patientId = appointment.getPatient().getId();
        this.appointmentType = appointment.getAppointmentType();
        this.availableHours = appointment.getAvailableHours();
        this.patientName = appointment.getPatient().getName();
        this.medicName = appointment.getMedic().getName();
        this.medicId = appointment.getMedic().getId();
        this.link = appointment.getLink();
        this.acceptedHour = appointment.getAcceptedHour();
    }

    public static AppointmentAcceptResponse of(Appointment appointment) {
        if (appointment == null) return null;
        return new AppointmentAcceptResponse(appointment);
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

    public String getMedicName() {
        return medicName;
    }

    public Integer getMedicId() {
        return medicId;
    }

    public String getLink() {
        return link;
    }

    public String getAcceptedHour() {
        return acceptedHour;
    }
}
