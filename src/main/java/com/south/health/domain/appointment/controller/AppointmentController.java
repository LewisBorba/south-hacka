package com.south.health.domain.appointment.controller;

import com.south.health.domain.appointment.controller.request.AppointmentRequest;
import com.south.health.domain.appointment.controller.response.AppointmentResponse;
import com.south.health.domain.appointment.model.Appointment;
import com.south.health.domain.appointment.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    @ApiOperation(value ="Endpoint that request a appointment with a doctor")
    public AppointmentResponse scheduleAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentService.scheduleAppointment(appointmentRequest);
        return AppointmentResponse.of(appointment);
    }

}
