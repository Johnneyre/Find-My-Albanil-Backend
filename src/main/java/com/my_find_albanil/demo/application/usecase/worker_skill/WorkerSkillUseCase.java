package com.my_find_albanil.demo.application.usecase.worker_skill;

import com.my_find_albanil.demo.application.mapper.WorkerSkillMapper;
import com.my_find_albanil.demo.domain.models.request.worker_skill.WorkerSkillRequestDTO;
import com.my_find_albanil.demo.domain.models.response.worker_skill.WorkerSkillResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.WorkerSkillData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.repository.WorkerSkillDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.repository.WorkerProfileDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.repository.SkillDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerSkillUseCase {
    
    private final WorkerSkillDataRepository workerSkillRepository;
    private final WorkerProfileDataRepository workerProfileRepository;
    private final SkillDataRepository skillRepository;
    private final WorkerSkillMapper workerSkillMapper;
    
    public WorkerSkillResponseDTO createWorkerSkill(WorkerSkillRequestDTO requestDTO) {
        WorkerProfileData workerProfile = workerProfileRepository.findById(requestDTO.getWorkerProfileId())
            .orElseThrow(() -> new RuntimeException("Worker profile not found with id: " + requestDTO.getWorkerProfileId()));
        
        SkillData skill = skillRepository.findById(requestDTO.getSkillId())
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + requestDTO.getSkillId()));
        
        WorkerSkillData workerSkill = workerSkillMapper.toEntity(requestDTO, workerProfile, skill);
        WorkerSkillData savedWorkerSkill = workerSkillRepository.save(workerSkill);
        return workerSkillMapper.toResponseDTO(savedWorkerSkill);
    }
    
    public WorkerSkillResponseDTO getWorkerSkillById(Long id) {
        WorkerSkillData workerSkill = workerSkillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Worker skill not found with id: " + id));
        return workerSkillMapper.toResponseDTO(workerSkill);
    }
    
    public List<WorkerSkillResponseDTO> getWorkerSkillsByWorkerProfileId(Long workerProfileId) {
        return workerSkillRepository.findByWorkerProfileId(workerProfileId).stream()
            .map(workerSkillMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<WorkerSkillResponseDTO> getWorkerSkillsBySkillId(Long skillId) {
        return workerSkillRepository.findBySkillId(skillId).stream()
            .map(workerSkillMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public WorkerSkillResponseDTO updateWorkerSkill(Long id, WorkerSkillRequestDTO requestDTO) {
        WorkerSkillData existingWorkerSkill = workerSkillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Worker skill not found with id: " + id));
        
        existingWorkerSkill.setLevel(requestDTO.getLevel());
        existingWorkerSkill.setYearsExperience(requestDTO.getYearsExperience());
        
        WorkerSkillData updatedWorkerSkill = workerSkillRepository.save(existingWorkerSkill);
        return workerSkillMapper.toResponseDTO(updatedWorkerSkill);
    }
    
    public void deleteWorkerSkill(Long id) {
        if (!workerSkillRepository.findById(id).isPresent()) {
            throw new RuntimeException("Worker skill not found with id: " + id);
        }
        workerSkillRepository.deleteById(id);
    }
}
