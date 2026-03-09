package com.jarvis.notification_service.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AppointmentCreatedEvent {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentTime;
}
