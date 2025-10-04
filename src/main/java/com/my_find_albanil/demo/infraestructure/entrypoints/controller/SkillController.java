package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.skill.SkillUseCase;
import com.my_find_albanil.demo.domain.models.request.skill.SkillRequestDTO;
import com.my_find_albanil.demo.domain.models.response.skill.SkillResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    
    private final SkillUseCase skillUseCase;
    
    @PostMapping
    public ResponseEntity<SkillResponseDTO> createSkill(@RequestBody SkillRequestDTO requestDTO) {
        SkillResponseDTO response = skillUseCase.createSkill(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillResponseDTO> getSkillById(@PathVariable Long id) {
        SkillResponseDTO response = skillUseCase.getSkillById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<SkillResponseDTO> getSkillByName(@PathVariable String name) {
        SkillResponseDTO response = skillUseCase.getSkillByName(name);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<SkillResponseDTO>> getAllSkills() {
        List<SkillResponseDTO> response = skillUseCase.getAllSkills();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SkillResponseDTO> updateSkill(@PathVariable Long id, @RequestBody SkillRequestDTO requestDTO) {
        SkillResponseDTO response = skillUseCase.updateSkill(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillUseCase.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}
