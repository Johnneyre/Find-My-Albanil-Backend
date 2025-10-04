package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.user.UserRequestDTO;
import com.my_find_albanil.demo.domain.models.response.user.UserResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public UserData toEntity(UserRequestDTO dto) {
        if (dto == null) return null;
        
        UserData entity = new UserData();
        entity.setId(dto.getId());
        entity.setRole(dto.getRole());
        entity.setEmail(dto.getEmail());
        entity.setPasswordHash(dto.getPasswordHash());
        entity.setFullName(dto.getFullName());
        entity.setPhone(dto.getPhone());
        entity.setLocation(dto.getLocation());
        entity.setBio(dto.getBio());
        entity.setAvatarUrl(dto.getAvatarUrl());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
    
    public UserResponseDTO toResponseDTO(UserData entity) {
        if (entity == null) return null;
        
        return new UserResponseDTO(
            entity.getId(),
            entity.getRole(),
            entity.getEmail(),
            entity.getFullName(),
            entity.getPhone(),
            entity.getLocation(),
            entity.getBio(),
            entity.getAvatarUrl(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
