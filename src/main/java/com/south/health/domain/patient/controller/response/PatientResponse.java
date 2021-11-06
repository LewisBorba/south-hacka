package com.south.health.domain.patient.controller.response;

import com.south.health.domain.patient.model.Patient;
import io.swagger.annotations.ApiModelProperty;

public class PatientResponse {

    @ApiModelProperty(example = "4")
    private final Integer id;

    @ApiModelProperty(example = "south-hacka")
    private final String name;

    private PatientResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
    }

    public static PatientResponse of(Patient patient) {
        if (patient == null) return null;
        return new PatientResponse(patient);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
