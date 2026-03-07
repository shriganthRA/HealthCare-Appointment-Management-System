package com.jarvis.auth_service.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jarvis.auth_service.config.JwtUtil;
import com.jarvis.auth_service.dto.UserAuthResponseDTO;
import com.jarvis.auth_service.dto.UserLoginRequestDTO;
import com.jarvis.auth_service.dto.UserRegisterRequestDTO;
import com.jarvis.auth_service.model.User;
import com.jarvis.auth_service.repository.UserRepo;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepo userRepo, JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // Auth Service for Registration request
    @Override
    public UserAuthResponseDTO register(UserRegisterRequestDTO userRegisterRequestDTO) {
        User user = User.builder()
                .name(userRegisterRequestDTO.getName())
                .email(userRegisterRequestDTO.getEmail())
                .password(passwordEncoder.encode(userRegisterRequestDTO.getPassword()))
                .role("PATIENT")
                .build();
                
        userRepo.save(user);

        // Generate the Token
        String token = jwtUtil.generateToken(user.getEmail());

        return UserAuthResponseDTO.builder()
                .id(user.getId().toString())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }

    // Auth Service for Login request
    @Override
    public UserAuthResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        
        User user = userRepo.findByEmail(userLoginRequestDTO.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(userLoginRequestDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate the Token
        String token = jwtUtil.generateToken(user.getEmail());

        return UserAuthResponseDTO.builder()
                    .id(user.getId().toString())
                    .name(user.getName())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .token(token)
                    .build();
    }
}
