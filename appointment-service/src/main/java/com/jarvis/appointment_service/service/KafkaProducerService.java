package com.jarvis.appointment_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.jarvis.appointment_service.event.AppointmentCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, AppointmentCreatedEvent> kafkaTemplate;


    public void sendAppointmentEvent(AppointmentCreatedEvent event) {
        kafkaTemplate.send("appointment-created", event);
    }
}
