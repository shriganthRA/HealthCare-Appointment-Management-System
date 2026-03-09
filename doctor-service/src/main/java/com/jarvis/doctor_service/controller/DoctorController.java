package com.jarvis.doctor_service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.doctor_service.dto.DoctorRequestDTO;
import com.jarvis.doctor_service.dto.DoctorResponseDTO;
import com.jarvis.doctor_service.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    
    // Add new Doctor
    @PostMapping
    public ResponseEntity<DoctorResponseDTO> addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        return ResponseEntity.status(201).body(doctorService.createDoctor(doctorRequestDTO));
    }

    // Get all Doctors
    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        return ResponseEntity.status(200).body(doctorService.getAllDoctors());
    }

    // Get Doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoctorResponseDTO>> getDoctor(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(doctorService.getDoctor(id));
    }
}
