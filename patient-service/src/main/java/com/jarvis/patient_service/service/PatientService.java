package com.jarvis.patient_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.jarvis.patient_service.dto.PatientRequestDTO;
import com.jarvis.patient_service.dto.PatientResponseDTO;
import com.jarvis.patient_service.mapper.PatientMapper;
import com.jarvis.patient_service.model.Patient;
import com.jarvis.patient_service.repository.PatientRepo;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    // Get all the Patient details
    public List<PatientResponseDTO> getAllPatient() {
        List<Patient> patients = patientRepo.findAll();

        return patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
    }

    // Get Patient details by Id
    public PatientResponseDTO getPatientbyId(UUID patientId) {
        Patient getPatient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with this ID " + patientId));
        
        return PatientMapper.toDTO(getPatient);
    }

    // Add a new Patient details
    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepo.existsByEmail(patientRequestDTO.getEmail())) {
            throw new RuntimeException("Patient already exists with this email ID " + patientRequestDTO.getEmail());
        }

        Patient createPatient = patientRepo.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(createPatient);
    }

    // Update a existing Patient details
    public PatientResponseDTO updatePatient(UUID patientId, PatientRequestDTO patientRequestDTO) {
        Patient existingPatient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not exists with this ID " + patientId));

        existingPatient.setEmail(patientRequestDTO.getEmail());
        existingPatient.setPhone(patientRequestDTO.getPhone());

        Patient updatePatient = patientRepo.save(existingPatient);
        return PatientMapper.toDTO(updatePatient);
    }

    // Delete a existing Patient details
    public void deletePatientbyId(UUID patientId) {
        patientRepo.deleteById(patientId);
    }
}
