package com.jarvis.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDTO {

    private String name;
    private String email;
    private String password;
    private String role;
}
