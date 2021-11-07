package com.south.health.domain.appointment.controller;

import com.south.health.domain.appointment.controller.request.AppointmentAcceptRequest;
import com.south.health.domain.appointment.controller.request.AppointmentRequest;
import com.south.health.domain.appointment.controller.response.AppointmentAcceptResponse;
import com.south.health.domain.appointment.controller.response.AppointmentResponse;
import com.south.health.domain.appointment.model.Appointment;
import com.south.health.domain.appointment.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    @ApiOperation(value = "Endpoint that request a appointment with a doctor")
    public AppointmentResponse scheduleAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentService.scheduleAppointment(appointmentRequest);
        return AppointmentResponse.of(appointment);
    }

    @PutMapping("/{appointmentId}")
    @ApiOperation(value = "Endpoint that accept a appointment with a patient")
    public AppointmentAcceptResponse acceptAppointment(@PathVariable Integer appointmentId,
                                                       @RequestBody AppointmentAcceptRequest appointmentAcceptRequest) {
        Appointment appointment = appointmentService.acceptAppointment(appointmentAcceptRequest, appointmentId);
        return AppointmentAcceptResponse.of(appointment);
    }

    @GetMapping("/requested-appointments/{patientId}")
    @ApiOperation("Endpoint that gets a list of requested appointments")
    public List<AppointmentResponse> getRequestedAppointments(@PathVariable Integer patientId) {
        List<Appointment> appointment = appointmentService.getRequestedAppointments(patientId);
        return appointment.stream().map(AppointmentResponse::of).collect(Collectors.toList());
    }

    @GetMapping("/accepted-appointments/{patientId}")
    @ApiOperation("Endpoint that gets a list of accepted appointments")
    public List<AppointmentAcceptResponse> getAcceptedAppointments(@PathVariable Integer patientId) {
        List<Appointment> appointment = appointmentService.getAcceptedAppointments(patientId);
        return appointment.stream().map(AppointmentAcceptResponse::of).collect(Collectors.toList());
    }


    @GetMapping("/available-appointments")
    @ApiOperation("Endpoint that gets all available appointments to accepts")
    public List<AppointmentResponse> getAvailableAppointments(@PathVariable String type) {
        List<Appointment> appointment = appointmentService.getAvailableAppointments(type);
        return appointment.stream().map(AppointmentResponse::of).collect(Collectors.toList());
    }

    @GetMapping("/scheduled-appointments/{medicId}")
    @ApiOperation("Endpoint that gets all scheduled appointments")
    public List<AppointmentAcceptResponse> getScheduledAppointments(@PathVariable Integer medicId) {
        List<Appointment> appointment = appointmentService.getScheduledAppointments(medicId);
        return appointment.stream().map(AppointmentAcceptResponse::of).collect(Collectors.toList());
    }

    @DeleteMapping("/cancel-appointment/{appointmentId}")
    @ApiOperation("Endpoint that cancel appointment")
    public AppointmentAcceptResponse cancelAppointment(@PathVariable Integer appointmentId) {
        Appointment appointment = appointmentService.cancelAppointment(appointmentId);
        return AppointmentAcceptResponse.of(appointment);
    }


}
