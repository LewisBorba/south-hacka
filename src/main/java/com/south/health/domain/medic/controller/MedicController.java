package com.south.health.domain.medic.controller;

import com.south.health.domain.medic.controller.request.MedicRequest;
import com.south.health.domain.medic.controller.response.MedicResponse;
import com.south.health.domain.medic.model.Medic;
import com.south.health.domain.medic.service.MedicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medic")
public class MedicController {
    private final MedicService medicService;

    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @PostMapping
    @ApiOperation(value = "Create medic")
    public MedicResponse save(@RequestBody MedicRequest medicRequest) {
        Medic medic = medicService.registerMedic(medicRequest);
        return MedicResponse.of(medic);
    }
}
