package com.my_find_albanil.demo.application.usecase.application;

import com.my_find_albanil.demo.application.mapper.ApplicationMapper;
import com.my_find_albanil.demo.domain.models.request.application.ApplicationRequestDTO;
import com.my_find_albanil.demo.domain.models.response.application.ApplicationResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.application.ApplicationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.application.repository.ApplicationDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.job.repository.JobDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.repository.WorkerProfileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationUseCase {
    
    private final ApplicationDataRepository applicationRepository;
    private final JobDataRepository jobRepository;
    private final WorkerProfileDataRepository workerProfileRepository;
    private final ApplicationMapper applicationMapper;
    
    public ApplicationResponseDTO createApplication(ApplicationRequestDTO requestDTO) {
        JobData job = jobRepository.findById(requestDTO.getJobId())
            .orElseThrow(() -> new RuntimeException("Job not found with id: " + requestDTO.getJobId()));
        
        WorkerProfileData workerProfile = workerProfileRepository.findById(requestDTO.getWorkerProfileId())
            .orElseThrow(() -> new RuntimeException("Worker profile not found with id: " + requestDTO.getWorkerProfileId()));
        
        ApplicationData application = applicationMapper.toEntity(requestDTO, job, workerProfile);
        ApplicationData savedApplication = applicationRepository.save(application);
        return applicationMapper.toResponseDTO(savedApplication);
    }
    
    public ApplicationResponseDTO getApplicationById(Long id) {
        ApplicationData application = applicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
        return applicationMapper.toResponseDTO(application);
    }
    
    public List<ApplicationResponseDTO> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId).stream()
            .map(applicationMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<ApplicationResponseDTO> getApplicationsByWorkerProfileId(Long workerProfileId) {
        return applicationRepository.findByWorkerProfileId(workerProfileId).stream()
            .map(applicationMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public ApplicationResponseDTO updateApplication(Long id, ApplicationRequestDTO requestDTO) {
        ApplicationData existingApplication = applicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
        
        existingApplication.setCoverLetter(requestDTO.getCoverLetter());
        existingApplication.setProposedRate(requestDTO.getProposedRate());
        existingApplication.setStatus(requestDTO.getStatus());
        
        ApplicationData updatedApplication = applicationRepository.save(existingApplication);
        return applicationMapper.toResponseDTO(updatedApplication);
    }
    
    public void deleteApplication(Long id) {
        if (!applicationRepository.findById(id).isPresent()) {
            throw new RuntimeException("Application not found with id: " + id);
        }
        applicationRepository.deleteById(id);
    }
}
