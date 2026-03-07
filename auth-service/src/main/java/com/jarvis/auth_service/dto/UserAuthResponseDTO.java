package com.jarvis.auth_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserAuthResponseDTO {

    private String id;
    private String name;
    private String email;
    private String role;
    private String token;
}
