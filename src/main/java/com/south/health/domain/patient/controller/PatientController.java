package com.south.health.domain.patient.controller;

import com.south.health.domain.patient.controller.request.PatientRequest;
import com.south.health.domain.patient.controller.response.PatientResponse;
import com.south.health.domain.patient.model.Patient;
import com.south.health.domain.patient.service.PatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @ApiOperation(value = "Create patient")
    public PatientResponse save(@RequestBody PatientRequest patientRequest) {
        Patient patient = patientService.registerPatient(patientRequest);
        return PatientResponse.of(patient);
    }
}
