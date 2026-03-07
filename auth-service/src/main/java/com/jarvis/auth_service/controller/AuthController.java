package com.jarvis.auth_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.auth_service.dto.UserAuthResponseDTO;
import com.jarvis.auth_service.dto.UserLoginRequestDTO;
import com.jarvis.auth_service.dto.UserRegisterRequestDTO;
import com.jarvis.auth_service.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Auth Controller for Register request
    @PostMapping("/register")
    public ResponseEntity<UserAuthResponseDTO> register(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        return ResponseEntity.status(201).body(authService.register(userRegisterRequestDTO));
    }

    // Auth Controller for Login request
    @PostMapping("/login")
    public ResponseEntity<UserAuthResponseDTO> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        return ResponseEntity.status(200).body(authService.login(userLoginRequestDTO));
    }
    
    
}
