package com.jarvis.appointment_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.appointment_service.dto.AppointmentRequestDTO;
import com.jarvis.appointment_service.dto.AppointmentResponseDTO;
import com.jarvis.appointment_service.repository.AppointmentRepo;
import com.jarvis.appointment_service.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService, AppointmentRepo appointmentRepo) {
        this.appointmentService = appointmentService;
    }

    // Create an Appointment
    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> book(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return ResponseEntity.status(201).body(appointmentService.createAppointment(appointmentRequestDTO));
    }

    // Get Appointment details by Patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentbyPatient(@PathVariable String patientId) {
        return ResponseEntity.status(200).body(appointmentService.getAppointmentbyPatient(patientId));
    }

}
