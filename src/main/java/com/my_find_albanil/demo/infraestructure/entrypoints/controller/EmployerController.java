package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.employer.EmployerUseCase;
import com.my_find_albanil.demo.domain.models.request.employer.EmployerRequestDTO;
import com.my_find_albanil.demo.domain.models.response.employer.EmployerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employers")
@RequiredArgsConstructor
public class EmployerController {
    
    private final EmployerUseCase employerUseCase;
    
    @PostMapping
    public ResponseEntity<EmployerResponseDTO> createEmployer(@RequestBody EmployerRequestDTO requestDTO) {
        EmployerResponseDTO response = employerUseCase.createEmployer(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployerResponseDTO> getEmployerById(@PathVariable Long id) {
        EmployerResponseDTO response = employerUseCase.getEmployerById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<EmployerResponseDTO> getEmployerByUserId(@PathVariable UUID userId) {
        EmployerResponseDTO response = employerUseCase.getEmployerByUserId(userId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<EmployerResponseDTO>> getAllEmployers() {
        List<EmployerResponseDTO> response = employerUseCase.getAllEmployers();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmployerResponseDTO> updateEmployer(@PathVariable Long id, @RequestBody EmployerRequestDTO requestDTO) {
        EmployerResponseDTO response = employerUseCase.updateEmployer(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerUseCase.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }
}
