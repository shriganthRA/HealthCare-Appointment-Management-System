package com.jarvis.appointment_service.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AppointmentCreatedEvent {

    public AppointmentCreatedEvent(String string, String patientId2, String doctorId2, String string2) {
        //TODO Auto-generated constructor stub
    }
    private String appointmentId;
    private String PatientId;
    private String DoctorId;
    private String appointmentTime;
}
