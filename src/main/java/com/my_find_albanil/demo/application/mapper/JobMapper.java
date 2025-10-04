package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.job.JobRequestDTO;
import com.my_find_albanil.demo.domain.models.response.job.JobResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    
    public JobData toEntity(JobRequestDTO dto, EmployerData employer) {
        if (dto == null) return null;
        
        JobData entity = new JobData();
        entity.setId(dto.getId());
        entity.setEmployer(employer);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setLocation(dto.getLocation());
        entity.setSalaryRange(dto.getSalaryRange());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setFullTime(dto.getFullTime());
        entity.setRemoteAllowed(dto.getRemoteAllowed());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setStatus(dto.getStatus());
        return entity;
    }
    
    public JobResponseDTO toResponseDTO(JobData entity) {
        if (entity == null) return null;
        
        return new JobResponseDTO(
            entity.getId(),
            entity.getEmployer() != null ? entity.getEmployer().getId() : null,
            entity.getTitle(),
            entity.getDescription(),
            entity.getLocation(),
            entity.getSalaryRange(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.getFullTime(),
            entity.getRemoteAllowed(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            entity.getStatus()
        );
    }
}
