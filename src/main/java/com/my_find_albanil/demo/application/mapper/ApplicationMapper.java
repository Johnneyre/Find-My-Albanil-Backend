package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.application.ApplicationRequestDTO;
import com.my_find_albanil.demo.domain.models.response.application.ApplicationResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.application.ApplicationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {
    
    public ApplicationData toEntity(ApplicationRequestDTO dto, JobData job, WorkerProfileData workerProfile) {
        if (dto == null) return null;
        
        ApplicationData entity = new ApplicationData();
        entity.setId(dto.getId());
        entity.setJob(job);
        entity.setWorkerProfile(workerProfile);
        entity.setCoverLetter(dto.getCoverLetter());
        entity.setProposedRate(dto.getProposedRate());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
    
    public ApplicationResponseDTO toResponseDTO(ApplicationData entity) {
        if (entity == null) return null;
        
        return new ApplicationResponseDTO(
            entity.getId(),
            entity.getJob() != null ? entity.getJob().getId() : null,
            entity.getWorkerProfile() != null ? entity.getWorkerProfile().getId() : null,
            entity.getCoverLetter(),
            entity.getProposedRate(),
            entity.getStatus(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
