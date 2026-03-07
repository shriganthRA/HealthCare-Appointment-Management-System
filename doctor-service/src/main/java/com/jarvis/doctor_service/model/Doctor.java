package com.jarvis.doctor_service.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String availability;

    @Column(nullable = false)
    private boolean active;
}
