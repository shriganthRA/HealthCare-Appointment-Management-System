package com.jarvis.appointment_service.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jarvis.appointment_service.dto.PatientDTO;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientClient {

    @GetMapping("/patient/{id}")
    PatientDTO getPatientbyId(@PathVariable UUID id);
}
