package com.my_find_albanil.demo.application.usecase.worker_profile;

import com.my_find_albanil.demo.application.mapper.WorkerProfileMapper;
import com.my_find_albanil.demo.domain.models.request.worker_profile.WorkerProfileRequestDTO;
import com.my_find_albanil.demo.domain.models.response.worker_profile.WorkerProfileResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.repository.WorkerProfileDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerProfileUseCase {
    
    private final WorkerProfileDataRepository workerProfileRepository;
    private final UserDataRepository userRepository;
    private final WorkerProfileMapper workerProfileMapper;
    
    public WorkerProfileResponseDTO createWorkerProfile(WorkerProfileRequestDTO requestDTO) {
        UserData user = userRepository.findById(requestDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getUserId()));
        
        WorkerProfileData workerProfile = workerProfileMapper.toEntity(requestDTO, user);
        WorkerProfileData savedProfile = workerProfileRepository.save(workerProfile);
        return workerProfileMapper.toResponseDTO(savedProfile);
    }
    
    public WorkerProfileResponseDTO getWorkerProfileById(Long id) {
        WorkerProfileData profile = workerProfileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Worker profile not found with id: " + id));
        return workerProfileMapper.toResponseDTO(profile);
    }
    
    public WorkerProfileResponseDTO getWorkerProfileByUserId(UUID userId) {
        WorkerProfileData profile = workerProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Worker profile not found for user id: " + userId));
        return workerProfileMapper.toResponseDTO(profile);
    }
    
    public List<WorkerProfileResponseDTO> getWorkerProfilesByTrade(String trade) {
        return workerProfileRepository.findByTrade(trade).stream()
            .map(workerProfileMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<WorkerProfileResponseDTO> getAvailableWorkerProfiles() {
        return workerProfileRepository.findByAvailability(true).stream()
            .map(workerProfileMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<WorkerProfileResponseDTO> getAllWorkerProfiles() {
        return workerProfileRepository.findAll().stream()
            .map(workerProfileMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public WorkerProfileResponseDTO updateWorkerProfile(Long id, WorkerProfileRequestDTO requestDTO) {
        WorkerProfileData existingProfile = workerProfileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Worker profile not found with id: " + id));
        
        existingProfile.setTrade(requestDTO.getTrade());
        existingProfile.setExperienceYears(requestDTO.getExperienceYears());
        existingProfile.setHourlyRate(requestDTO.getHourlyRate());
        existingProfile.setAvailability(requestDTO.getAvailability());
        existingProfile.setGear(requestDTO.getGear());
        existingProfile.setCertifications(requestDTO.getCertifications());
        existingProfile.setResumeUrl(requestDTO.getResumeUrl());
        
        WorkerProfileData updatedProfile = workerProfileRepository.save(existingProfile);
        return workerProfileMapper.toResponseDTO(updatedProfile);
    }
    
    public void deleteWorkerProfile(Long id) {
        if (!workerProfileRepository.findById(id).isPresent()) {
            throw new RuntimeException("Worker profile not found with id: " + id);
        }
        workerProfileRepository.deleteById(id);
    }
}
