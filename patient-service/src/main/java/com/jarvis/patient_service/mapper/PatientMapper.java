package com.jarvis.patient_service.mapper;

import com.jarvis.patient_service.dto.PatientRequestDTO;
import com.jarvis.patient_service.dto.PatientResponseDTO;
import com.jarvis.patient_service.model.Patient;


public class PatientMapper {

    // RequestDTO to Model
    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setPhone(patientRequestDTO.getPhone());

        return patient;
    }

    // Model to ResponseDTO
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setPhone(patient.getPhone());

        return patientResponseDTO;
    }
}
