package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.job.JobUseCase;
import com.my_find_albanil.demo.domain.models.request.job.JobRequestDTO;
import com.my_find_albanil.demo.domain.models.response.job.JobResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@Tag(name = "Jobs", description = "Endpoints para gestión de ofertas de trabajo")
public class JobController {
    
    private final JobUseCase jobUseCase;
    
    @PostMapping
    @Operation(summary = "Crear oferta de trabajo", description = "Crea una nueva oferta de trabajo")
    public ResponseEntity<JobResponseDTO> createJob(@Valid @RequestBody JobRequestDTO requestDTO) {
        JobResponseDTO response = jobUseCase.createJob(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById(@PathVariable Long id) {
        JobResponseDTO response = jobUseCase.getJobById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<JobResponseDTO>> getJobsByEmployerId(@PathVariable Long employerId) {
        List<JobResponseDTO> response = jobUseCase.getJobsByEmployerId(employerId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobResponseDTO>> getJobsByStatus(@PathVariable String status) {
        List<JobResponseDTO> response = jobUseCase.getJobsByStatus(status);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/location/{location}")
    public ResponseEntity<List<JobResponseDTO>> getJobsByLocation(@PathVariable String location) {
        List<JobResponseDTO> response = jobUseCase.getJobsByLocation(location);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> getAllJobs() {
        List<JobResponseDTO> response = jobUseCase.getAllJobs();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobResponseDTO> updateJob(@PathVariable Long id, @RequestBody JobRequestDTO requestDTO) {
        JobResponseDTO response = jobUseCase.updateJob(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobUseCase.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
