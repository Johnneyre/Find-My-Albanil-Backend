package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.worker_skill.WorkerSkillRequestDTO;
import com.my_find_albanil.demo.domain.models.response.worker_skill.WorkerSkillResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.WorkerSkillData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import org.springframework.stereotype.Component;

@Component
public class WorkerSkillMapper {
    
    public WorkerSkillData toEntity(WorkerSkillRequestDTO dto, WorkerProfileData workerProfile, SkillData skill) {
        if (dto == null) return null;
        
        WorkerSkillData entity = new WorkerSkillData();
        entity.setId(dto.getId());
        entity.setWorkerProfile(workerProfile);
        entity.setSkill(skill);
        entity.setLevel(dto.getLevel());
        entity.setYearsExperience(dto.getYearsExperience());
        return entity;
    }
    
    public WorkerSkillResponseDTO toResponseDTO(WorkerSkillData entity) {
        if (entity == null) return null;
        
        return new WorkerSkillResponseDTO(
            entity.getId(),
            entity.getWorkerProfile() != null ? entity.getWorkerProfile().getId() : null,
            entity.getSkill() != null ? entity.getSkill().getId() : null,
            entity.getLevel(),
            entity.getYearsExperience()
        );
    }
}
