// package com.jarvis.auth_service.mapper;

// import com.jarvis.auth_service.dto.UserRegisterRequestDTO;
// import com.jarvis.auth_service.dto.UserLoginResponseDTO;
// import com.jarvis.auth_service.model.User;

// public class UserMapper {

//     // DTO to Model
//     public static User toModel(UserRegisterRequestDTO userRequestDTO) {
//         User user = new User();
//         user.setName(userRequestDTO.getName());
//         user.setEmail(userRequestDTO.getEmail());
//         user.setPassword(userRequestDTO.getPassword());
//         user.setRole(userRequestDTO.getRole());

//         return user;
//     }

//     // Model to DTO
//     public static UserLoginResponseDTO toDTO(User user) {
//         UserLoginResponseDTO userResponseDTO = new UserLoginResponseDTO();
//         userResponseDTO.setId(user.getId().toString());
//         userResponseDTO.setName(user.getName());
//         userResponseDTO.setEmail(user.getEmail());
//         userResponseDTO.setRole(user.getRole());

//         return userResponseDTO;
//     }
// }
