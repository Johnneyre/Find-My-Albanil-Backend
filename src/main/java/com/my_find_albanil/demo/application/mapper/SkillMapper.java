package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.skill.SkillRequestDTO;
import com.my_find_albanil.demo.domain.models.response.skill.SkillResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {
    
    public SkillData toEntity(SkillRequestDTO dto) {
        if (dto == null) return null;
        
        SkillData entity = new SkillData();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
    
    public SkillResponseDTO toResponseDTO(SkillData entity) {
        if (entity == null) return null;
        
        return new SkillResponseDTO(
            entity.getId(),
            entity.getName()
        );
    }
}
