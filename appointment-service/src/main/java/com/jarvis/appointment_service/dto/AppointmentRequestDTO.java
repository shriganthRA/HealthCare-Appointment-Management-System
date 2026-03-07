package com.jarvis.appointment_service.dto;

import lombok.*;

@Getter
@Setter
public class AppointmentRequestDTO {

    private String patientId;
    private String doctorId;
    private String appointmentTime;
}
