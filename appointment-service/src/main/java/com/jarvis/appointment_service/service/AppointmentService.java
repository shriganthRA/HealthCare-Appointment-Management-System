package com.jarvis.appointment_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarvis.appointment_service.dto.AppointmentRequestDTO;
import com.jarvis.appointment_service.dto.AppointmentResponseDTO;
import com.jarvis.appointment_service.mapper.AppointmentMapper;
import com.jarvis.appointment_service.model.Appointment;
import com.jarvis.appointment_service.repository.AppointmentRepo;

@Service
public class AppointmentService {

    private final AppointmentRepo appointmentRepo;

    public AppointmentService(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    // Create an Appointment
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        Appointment newAppointment = appointmentRepo.save(AppointmentMapper.toModel(appointmentRequestDTO));

        return AppointmentMapper.toDTO(newAppointment);
    }

    // Get Appointment Details by Patient Id
    public List<AppointmentResponseDTO> getAppointmentbyPatient(String patientId) {
        return appointmentRepo.findByPatientId(patientId).stream().map(p -> AppointmentMapper.toDTO(p)).toList();
    }
}
