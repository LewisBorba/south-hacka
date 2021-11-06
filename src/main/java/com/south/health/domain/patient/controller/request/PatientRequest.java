package com.south.health.domain.patient.controller.request;

import io.swagger.annotations.ApiParam;

public class PatientRequest {

    @ApiParam(example = "south-hacka")
    private final String username;

    @ApiParam(example = "email@email.com")
    private final String email;

    @ApiParam(example = "T3STE!")
    private final  String password;

    public PatientRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
