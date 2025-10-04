package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.worker_profile.WorkerProfileRequestDTO;
import com.my_find_albanil.demo.domain.models.response.worker_profile.WorkerProfileResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class WorkerProfileMapper {
    
    public WorkerProfileData toEntity(WorkerProfileRequestDTO dto, UserData user) {
        if (dto == null) return null;
        
        WorkerProfileData entity = new WorkerProfileData();
        entity.setId(dto.getId());
        entity.setUser(user);
        entity.setTrade(dto.getTrade());
        entity.setExperienceYears(dto.getExperienceYears());
        entity.setHourlyRate(dto.getHourlyRate());
        entity.setAvailability(dto.getAvailability());
        entity.setGear(dto.getGear());
        entity.setCertifications(dto.getCertifications());
        entity.setResumeUrl(dto.getResumeUrl());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
    
    public WorkerProfileResponseDTO toResponseDTO(WorkerProfileData entity) {
        if (entity == null) return null;
        
        return new WorkerProfileResponseDTO(
            entity.getId(),
            entity.getUser() != null ? entity.getUser().getId() : null,
            entity.getTrade(),
            entity.getExperienceYears(),
            entity.getHourlyRate(),
            entity.getAvailability(),
            entity.getGear(),
            entity.getCertifications(),
            entity.getResumeUrl(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
