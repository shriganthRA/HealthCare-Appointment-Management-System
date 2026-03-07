package com.jarvis.appointment_service.dto;

import lombok.*;

@Getter
@Setter
public class AppointmentResponseDTO {

    private String id;
    private String patientId;
    private String doctorId;
    private String appointmentTime;
    private String status;
}
