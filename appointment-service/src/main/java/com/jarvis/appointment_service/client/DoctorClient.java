package com.jarvis.appointment_service.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jarvis.appointment_service.dto.DoctorDTO;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorClient {

    @GetMapping("/doctor/{id}")
    DoctorDTO getDoctor(@PathVariable UUID id);
}
