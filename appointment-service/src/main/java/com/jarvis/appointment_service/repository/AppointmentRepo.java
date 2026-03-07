package com.jarvis.appointment_service.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.appointment_service.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, UUID> {
    List<Appointment> findByPatientId(String patientId);

    List<Appointment> findByDoctorId(String doctorId);
}
