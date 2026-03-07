package com.jarvis.doctor_service.dto;

import lombok.*;

@Getter
@Setter
public class DoctorResponseDTO {

    private String id;
    private String name;
    private String specialization;
    private String availability;
}
