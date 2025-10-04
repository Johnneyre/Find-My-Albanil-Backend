package com.my_find_albanil.demo.application.usecase.user;

import com.my_find_albanil.demo.application.mapper.UserMapper;
import com.my_find_albanil.demo.domain.models.request.user.UserRequestDTO;
import com.my_find_albanil.demo.domain.models.response.user.UserResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserUseCase {
    
    private final UserDataRepository userRepository;
    private final UserMapper userMapper;
    
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        UserData user = userMapper.toEntity(requestDTO);
        UserData savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }
    
    public UserResponseDTO getUserById(UUID id) {
        UserData user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toResponseDTO(user);
    }
    
    public UserResponseDTO getUserByEmail(String email) {
        UserData user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return userMapper.toResponseDTO(user);
    }
    
    public UserResponseDTO updateUser(UUID id, UserRequestDTO requestDTO) {
        UserData existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        existingUser.setRole(requestDTO.getRole());
        existingUser.setEmail(requestDTO.getEmail());
        existingUser.setPasswordHash(requestDTO.getPasswordHash());
        existingUser.setFullName(requestDTO.getFullName());
        existingUser.setPhone(requestDTO.getPhone());
        existingUser.setLocation(requestDTO.getLocation());
        existingUser.setBio(requestDTO.getBio());
        existingUser.setAvatarUrl(requestDTO.getAvatarUrl());
        
        UserData updatedUser = userRepository.save(existingUser);
        return userMapper.toResponseDTO(updatedUser);
    }
    
    public void deleteUser(UUID id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
    
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
