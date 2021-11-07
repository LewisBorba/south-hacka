package com.south.health.domain.appointment.model;

import com.south.health.domain.appointment.controller.request.AppointmentAcceptRequest;
import com.south.health.domain.appointment.controller.request.AppointmentRequest;
import com.south.health.domain.medic.model.Medic;
import com.south.health.domain.patient.model.Patient;

import javax.persistence.*;

@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "appointment_type")
    private String appointmentType;

    @Column(name = "available_hours")
    private String availableHours;

    @Column
    private String link;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medic")
    private Medic medic;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "accepted_hour")
    private String acceptedHour;

    /**
     * @deprecated (should be used only by frameworks)
     */
    @Deprecated(since = "0")
    public Appointment() {
    }

    private Appointment(String appointmentType, String availableHours, Status status, Patient patient) {
        this.appointmentType = appointmentType;
        this.availableHours = availableHours;
        this.status = status;
        this.patient = patient;
    }

    public static Appointment of(AppointmentRequest appointmentRequest, Patient patient) {
        if (appointmentRequest == null || patient == null) return null;
        return new Appointment(appointmentRequest.getAppointmentType(), appointmentRequest.getAvailableHours(), Status.REQUESTED, patient);
    }

    public Integer getId() {
        return id;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public String getLink() {
        return link;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public Status getStatus() {
        return status;
    }

    public void updateBy(AppointmentAcceptRequest appointmentAcceptRequest, Medic medic) {
        this.medic = medic;
        this.link = appointmentAcceptRequest.getLink();
        this.acceptedHour = appointmentAcceptRequest.getAcceptedHour();
        this.status = Status.ACCEPTED;
    }

    public String getAcceptedHour() {
        return acceptedHour;
    }

    public void cancel() {
        this.status = Status.CANCELLED;
    }
}
