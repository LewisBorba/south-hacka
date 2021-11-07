package com.south.health.domain.appointment.controller.request;

import io.swagger.annotations.ApiParam;

public class AppointmentRequest {


    @ApiParam(example = "1")
    private final Integer idPatient;
    @ApiParam(example = "Sexta e quintas a tarde")
    private final String availableHours;
    @ApiParam(example = "Orientação profissional")
    private final String appointmentType;

    public AppointmentRequest(Integer idPatient, String availableHours, String appointmentType) {
        this.idPatient = idPatient;
        this.availableHours = availableHours;
        this.appointmentType = appointmentType;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public String getAppointmentType() {
        return appointmentType;
    }
}
