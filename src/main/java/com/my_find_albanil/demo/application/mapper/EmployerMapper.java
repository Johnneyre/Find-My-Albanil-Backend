package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.employer.EmployerRequestDTO;
import com.my_find_albanil.demo.domain.models.response.employer.EmployerResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class EmployerMapper {
    
    public EmployerData toEntity(EmployerRequestDTO dto, UserData user) {
        if (dto == null) return null;
        
        EmployerData entity = new EmployerData();
        entity.setId(dto.getId());
        entity.setUser(user);
        entity.setCompanyName(dto.getCompanyName());
        entity.setCompanyDescription(dto.getCompanyDescription());
        entity.setCompanyLogoUrl(dto.getCompanyLogoUrl());
        entity.setWebsite(dto.getWebsite());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
    
    public EmployerResponseDTO toResponseDTO(EmployerData entity) {
        if (entity == null) return null;
        
        return new EmployerResponseDTO(
            entity.getId(),
            entity.getUser() != null ? entity.getUser().getId() : null,
            entity.getCompanyName(),
            entity.getCompanyDescription(),
            entity.getCompanyLogoUrl(),
            entity.getWebsite(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
