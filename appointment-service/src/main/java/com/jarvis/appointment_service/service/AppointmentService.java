package com.jarvis.appointment_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jarvis.appointment_service.client.DoctorClient;
import com.jarvis.appointment_service.client.PatientClient;
import com.jarvis.appointment_service.dto.AppointmentRequestDTO;
import com.jarvis.appointment_service.dto.AppointmentResponseDTO;
import com.jarvis.appointment_service.dto.DoctorDTO;
import com.jarvis.appointment_service.dto.PatientDTO;
import com.jarvis.appointment_service.event.AppointmentCreatedEvent;
import com.jarvis.appointment_service.mapper.AppointmentMapper;
import com.jarvis.appointment_service.model.Appointment;
import com.jarvis.appointment_service.repository.AppointmentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final KafkaProducerService kafkaProducerService;
    private final AppointmentRepo appointmentRepo;
    private final DoctorClient doctorClient;
    private final PatientClient patientClient;


    // Create an Appointment
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {

        DoctorDTO doctorDTO = doctorClient.getDoctor(UUID.fromString(appointmentRequestDTO.getDoctorId()));
        PatientDTO patientDTO = patientClient.getPatientbyId(UUID.fromString(appointmentRequestDTO.getPatientId()));

        if(doctorDTO == null || patientDTO == null) {
            throw new RuntimeException("Doctor or Patient not found");
        }
        
        appointmentRequestDTO.setStatus("BOOKED");
        Appointment newAppointment = appointmentRepo.save(AppointmentMapper.toModel(appointmentRequestDTO));

        AppointmentCreatedEvent appointmentEvent = new AppointmentCreatedEvent(
            newAppointment.getId().toString(),
            newAppointment.getPatientId(),
            newAppointment.getDoctorId(),
            newAppointment.getAppointmentTime().toString()
        );
        kafkaProducerService.sendAppointmentEvent(appointmentEvent);

        return AppointmentMapper.toDTO(newAppointment);
    }

    // Get Appointment Details by Patient Id
    public List<AppointmentResponseDTO> getAppointmentbyPatient(String patientId) {
        return appointmentRepo.findByPatientId(patientId).stream().map(p -> AppointmentMapper.toDTO(p)).toList();
    }
}
