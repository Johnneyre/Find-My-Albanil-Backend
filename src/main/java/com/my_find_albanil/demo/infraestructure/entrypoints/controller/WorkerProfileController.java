package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.worker_profile.WorkerProfileUseCase;
import com.my_find_albanil.demo.domain.models.request.worker_profile.WorkerProfileRequestDTO;
import com.my_find_albanil.demo.domain.models.response.worker_profile.WorkerProfileResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/worker-profiles")
@RequiredArgsConstructor
@Tag(name = "Worker Profiles", description = "Endpoints para gestión de perfiles de trabajadores")
public class WorkerProfileController {
    
    private final WorkerProfileUseCase workerProfileUseCase;
    
    @PostMapping
    @Operation(summary = "Crear perfil de trabajador", description = "Crea un nuevo perfil de trabajador")
    public ResponseEntity<WorkerProfileResponseDTO> createWorkerProfile(@Valid @RequestBody WorkerProfileRequestDTO requestDTO) {
        WorkerProfileResponseDTO response = workerProfileUseCase.createWorkerProfile(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener perfil por ID", description = "Obtiene un perfil de trabajador por su ID")
    public ResponseEntity<WorkerProfileResponseDTO> getWorkerProfileById(@PathVariable Long id) {
        WorkerProfileResponseDTO response = workerProfileUseCase.getWorkerProfileById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/user/{userId}")
    @Operation(summary = "Obtener perfil por usuario", description = "Obtiene el perfil de trabajador asociado a un usuario")
    public ResponseEntity<WorkerProfileResponseDTO> getWorkerProfileByUserId(@PathVariable UUID userId) {
        WorkerProfileResponseDTO response = workerProfileUseCase.getWorkerProfileByUserId(userId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/trade/{trade}")
    @Operation(summary = "Buscar por oficio", description = "Obtiene todos los trabajadores de un oficio específico")
    public ResponseEntity<List<WorkerProfileResponseDTO>> getWorkerProfilesByTrade(@PathVariable String trade) {
        List<WorkerProfileResponseDTO> response = workerProfileUseCase.getWorkerProfilesByTrade(trade);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/available")
    @Operation(summary = "Obtener trabajadores disponibles", description = "Lista todos los trabajadores disponibles actualmente")
    public ResponseEntity<List<WorkerProfileResponseDTO>> getAvailableWorkerProfiles() {
        List<WorkerProfileResponseDTO> response = workerProfileUseCase.getAvailableWorkerProfiles();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<WorkerProfileResponseDTO>> getAllWorkerProfiles() {
        List<WorkerProfileResponseDTO> response = workerProfileUseCase.getAllWorkerProfiles();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<WorkerProfileResponseDTO> updateWorkerProfile(@PathVariable Long id, @RequestBody WorkerProfileRequestDTO requestDTO) {
        WorkerProfileResponseDTO response = workerProfileUseCase.updateWorkerProfile(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkerProfile(@PathVariable Long id) {
        workerProfileUseCase.deleteWorkerProfile(id);
        return ResponseEntity.noContent().build();
    }
}
