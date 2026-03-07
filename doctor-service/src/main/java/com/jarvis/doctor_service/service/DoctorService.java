package com.jarvis.doctor_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarvis.doctor_service.dto.DoctorRequestDTO;
import com.jarvis.doctor_service.dto.DoctorResponseDTO;
import com.jarvis.doctor_service.mapper.DoctorMapper;
import com.jarvis.doctor_service.model.Doctor;
import com.jarvis.doctor_service.repository.DoctorRepo;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    
    // Register the Doctor
    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        if(doctorRepo.existsByName(doctorRequestDTO.getName())) {
            throw new RuntimeException("Doctor alredy exists");
        }

        Doctor newDoctor = doctorRepo.save(DoctorMapper.toModel(doctorRequestDTO));
        return DoctorMapper.toDTO(newDoctor);
    }

    // Get all Doctors
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepo.findAll().stream().map(d -> DoctorMapper.toDTO(d)).toList();
    }
}
