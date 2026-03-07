package com.jarvis.doctor_service.dto;

import lombok.*;


@Getter
@Setter
public class DoctorRequestDTO {
    
    private String name;
    private String specialization;
    private String availability;
}
