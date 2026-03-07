package com.jarvis.auth_service.service;

import com.jarvis.auth_service.dto.UserAuthResponseDTO;
import com.jarvis.auth_service.dto.UserLoginRequestDTO;
import com.jarvis.auth_service.dto.UserRegisterRequestDTO;

public interface AuthService {

    UserAuthResponseDTO register(UserRegisterRequestDTO userRegisterRequestDTO);

    UserAuthResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);
}
