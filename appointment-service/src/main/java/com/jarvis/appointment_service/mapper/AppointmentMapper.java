package com.jarvis.appointment_service.mapper;

import java.time.LocalDate;

import com.jarvis.appointment_service.dto.AppointmentRequestDTO;
import com.jarvis.appointment_service.dto.AppointmentResponseDTO;
import com.jarvis.appointment_service.model.Appointment;

public class AppointmentMapper {

    // DTO to Model
    public static Appointment toModel(AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = new Appointment();
        appointment.setPatientId(appointmentRequestDTO.getPatientId());
        appointment.setDoctorId(appointmentRequestDTO.getDoctorId());
        appointment.setAppointmentTime(LocalDate.parse(appointmentRequestDTO.getAppointmentTime()));
        
        return appointment;
    }

    // Model to DTO
    public static AppointmentResponseDTO toDTO(Appointment appointment) {
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setId(appointment.getId().toString());
        appointmentResponseDTO.setPatientId(appointment.getPatientId());
        appointmentResponseDTO.setDoctorId(appointment.getDoctorId());
        appointmentResponseDTO.setAppointmentTime(appointment.getAppointmentTime().toString());
        appointmentResponseDTO.setStatus("SHEDULED");

        return appointmentResponseDTO;
    }
}
