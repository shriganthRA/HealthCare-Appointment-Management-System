package com.jarvis.doctor_service.mapper;

import com.jarvis.doctor_service.dto.DoctorRequestDTO;
import com.jarvis.doctor_service.dto.DoctorResponseDTO;
import com.jarvis.doctor_service.model.Doctor;

public class DoctorMapper {

    // RequestDTO to Model
    public static Doctor toModel(DoctorRequestDTO doctorRequestDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDto.getName());
        doctor.setSpecialization(doctorRequestDto.getSpecialization());
        doctor.setAvailability(doctorRequestDto.getAvailability());

        return doctor;
    }

    // Model to RequestDTO
    public static DoctorResponseDTO toDTO(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getId().toString());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setSpecialization(doctor.getSpecialization());
        doctorResponseDTO.setAvailability(doctor.getAvailability());

        return doctorResponseDTO;
    }
}
