package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.worker_skill.WorkerSkillUseCase;
import com.my_find_albanil.demo.domain.models.request.worker_skill.WorkerSkillRequestDTO;
import com.my_find_albanil.demo.domain.models.response.worker_skill.WorkerSkillResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker-skills")
@RequiredArgsConstructor
public class WorkerSkillController {
    
    private final WorkerSkillUseCase workerSkillUseCase;
    
    @PostMapping
    public ResponseEntity<WorkerSkillResponseDTO> createWorkerSkill(@RequestBody WorkerSkillRequestDTO requestDTO) {
        WorkerSkillResponseDTO response = workerSkillUseCase.createWorkerSkill(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<WorkerSkillResponseDTO> getWorkerSkillById(@PathVariable Long id) {
        WorkerSkillResponseDTO response = workerSkillUseCase.getWorkerSkillById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/worker-profile/{workerProfileId}")
    public ResponseEntity<List<WorkerSkillResponseDTO>> getWorkerSkillsByWorkerProfileId(@PathVariable Long workerProfileId) {
        List<WorkerSkillResponseDTO> response = workerSkillUseCase.getWorkerSkillsByWorkerProfileId(workerProfileId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<WorkerSkillResponseDTO>> getWorkerSkillsBySkillId(@PathVariable Long skillId) {
        List<WorkerSkillResponseDTO> response = workerSkillUseCase.getWorkerSkillsBySkillId(skillId);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<WorkerSkillResponseDTO> updateWorkerSkill(@PathVariable Long id, @RequestBody WorkerSkillRequestDTO requestDTO) {
        WorkerSkillResponseDTO response = workerSkillUseCase.updateWorkerSkill(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkerSkill(@PathVariable Long id) {
        workerSkillUseCase.deleteWorkerSkill(id);
        return ResponseEntity.noContent().build();
    }
}
