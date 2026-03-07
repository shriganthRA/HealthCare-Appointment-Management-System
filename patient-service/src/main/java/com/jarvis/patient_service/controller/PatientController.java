package com.jarvis.patient_service.controller;

import com.jarvis.patient_service.service.PatientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.patient_service.dto.PatientRequestDTO;
import com.jarvis.patient_service.dto.PatientResponseDTO;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Get all Patients details
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.status(200).body(patientService.getAllPatient());
    }

    // Get Patients details by Id
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatientbyId(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(patientService.getPatientbyId(id));
    }

    // Update Patient details by Id
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
            @RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.status(200).body(patientService.updatePatient(id, patientRequestDTO));
    }

    // Create new Patient details
    @PostMapping
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.status(201).body(patientService.addPatient(patientRequestDTO));
    }

    // Delete Patient by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientbyId(@PathVariable UUID id) {
        return ResponseEntity.noContent().build();
    }
}
