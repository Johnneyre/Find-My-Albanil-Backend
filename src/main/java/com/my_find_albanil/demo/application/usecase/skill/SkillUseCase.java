package com.my_find_albanil.demo.application.usecase.skill;

import com.my_find_albanil.demo.application.mapper.SkillMapper;
import com.my_find_albanil.demo.domain.models.request.skill.SkillRequestDTO;
import com.my_find_albanil.demo.domain.models.response.skill.SkillResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.repository.SkillDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillUseCase {
    
    private final SkillDataRepository skillRepository;
    private final SkillMapper skillMapper;
    
    public SkillResponseDTO createSkill(SkillRequestDTO requestDTO) {
        if (skillRepository.existsByName(requestDTO.getName())) {
            throw new RuntimeException("Skill already exists with name: " + requestDTO.getName());
        }
        
        SkillData skill = skillMapper.toEntity(requestDTO);
        SkillData savedSkill = skillRepository.save(skill);
        return skillMapper.toResponseDTO(savedSkill);
    }
    
    public SkillResponseDTO getSkillById(Long id) {
        SkillData skill = skillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
        return skillMapper.toResponseDTO(skill);
    }
    
    public SkillResponseDTO getSkillByName(String name) {
        SkillData skill = skillRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("Skill not found with name: " + name));
        return skillMapper.toResponseDTO(skill);
    }
    
    public List<SkillResponseDTO> getAllSkills() {
        return skillRepository.findAll().stream()
            .map(skillMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public SkillResponseDTO updateSkill(Long id, SkillRequestDTO requestDTO) {
        SkillData existingSkill = skillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
        
        existingSkill.setName(requestDTO.getName());
        
        SkillData updatedSkill = skillRepository.save(existingSkill);
        return skillMapper.toResponseDTO(updatedSkill);
    }
    
    public void deleteSkill(Long id) {
        if (!skillRepository.findById(id).isPresent()) {
            throw new RuntimeException("Skill not found with id: " + id);
        }
        skillRepository.deleteById(id);
    }
}
