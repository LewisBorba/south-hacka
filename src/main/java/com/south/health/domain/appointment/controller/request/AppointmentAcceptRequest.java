package com.south.health.domain.appointment.controller.request;

public class AppointmentAcceptRequest {
    private String link;
    private Integer medicId;
    private String acceptedHour;

    public String getLink() {
        return link;
    }

    public Integer getMedicId() {
        return medicId;
    }

    public String getAcceptedHour() {
        return acceptedHour;
    }
}
