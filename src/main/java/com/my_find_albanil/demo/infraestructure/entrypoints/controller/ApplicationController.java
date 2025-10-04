package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.application.ApplicationUseCase;
import com.my_find_albanil.demo.domain.models.request.application.ApplicationRequestDTO;
import com.my_find_albanil.demo.domain.models.response.application.ApplicationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {
    
    private final ApplicationUseCase applicationUseCase;
    
    @PostMapping
    public ResponseEntity<ApplicationResponseDTO> createApplication(@RequestBody ApplicationRequestDTO requestDTO) {
        ApplicationResponseDTO response = applicationUseCase.createApplication(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponseDTO> getApplicationById(@PathVariable Long id) {
        ApplicationResponseDTO response = applicationUseCase.getApplicationById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getApplicationsByJobId(@PathVariable Long jobId) {
        List<ApplicationResponseDTO> response = applicationUseCase.getApplicationsByJobId(jobId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/worker-profile/{workerProfileId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getApplicationsByWorkerProfileId(@PathVariable Long workerProfileId) {
        List<ApplicationResponseDTO> response = applicationUseCase.getApplicationsByWorkerProfileId(workerProfileId);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponseDTO> updateApplication(@PathVariable Long id, @RequestBody ApplicationRequestDTO requestDTO) {
        ApplicationResponseDTO response = applicationUseCase.updateApplication(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationUseCase.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
