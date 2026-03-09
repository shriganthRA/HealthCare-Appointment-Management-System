package com.jarvis.notification_service.service;

import org.springframework.stereotype.Service;

import com.jarvis.notification_service.event.AppointmentCreatedEvent;

@Service
public class NotificationService {

    public void sendNotification(AppointmentCreatedEvent event) {
        System.out.println("Notification Sent!");
        System.out.println("Appointment ID: " + event.getAppointmentId());
        System.out.println("Patient ID: " + event.getPatientId());
        System.out.println("Doctor ID: " + event.getDoctorId());
        System.out.println("Appointment Time: " + event.getAppointmentTime());
    }
}
