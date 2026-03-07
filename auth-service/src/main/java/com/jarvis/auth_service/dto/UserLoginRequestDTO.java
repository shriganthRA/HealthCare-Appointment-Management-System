package com.jarvis.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDTO {

    private String email;
    private String password;
}
