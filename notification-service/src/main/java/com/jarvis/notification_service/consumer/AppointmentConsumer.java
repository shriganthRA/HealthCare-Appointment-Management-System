package com.jarvis.notification_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jarvis.notification_service.event.AppointmentCreatedEvent;
import com.jarvis.notification_service.service.NotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "appointment-created", groupId = "notification-group")
    public void consume(AppointmentCreatedEvent event) {
        System.out.println("Received Appointment Event");
        notificationService.sendNotification(event);
    }
}
