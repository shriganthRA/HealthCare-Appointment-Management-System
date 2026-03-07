package com.jarvis.doctor_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.doctor_service.model.Doctor;
import java.util.List;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, UUID> {
    boolean existsByName(String name);

    List<Doctor> findBySpecialization(String specialization);
}
