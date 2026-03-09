package com.jarvis.appointment_service.dto;

import lombok.Data;

@Data
public class DoctorDTO {

    private String id;
    private String name;
    private String specialization;
    private String availability;
}
