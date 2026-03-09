package com.jarvis.doctor_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "appointment-service", url = "http://localhost:")
public interface AppointmentClient {

}
