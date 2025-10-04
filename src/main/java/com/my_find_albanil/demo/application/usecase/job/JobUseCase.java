package com.my_find_albanil.demo.application.usecase.job;

import com.my_find_albanil.demo.application.mapper.JobMapper;
import com.my_find_albanil.demo.domain.models.request.job.JobRequestDTO;
import com.my_find_albanil.demo.domain.models.response.job.JobResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.job.repository.JobDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.repository.EmployerDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobUseCase {
    
    private final JobDataRepository jobRepository;
    private final EmployerDataRepository employerRepository;
    private final JobMapper jobMapper;
    
    public JobResponseDTO createJob(JobRequestDTO requestDTO) {
        EmployerData employer = employerRepository.findById(requestDTO.getEmployerId())
            .orElseThrow(() -> new RuntimeException("Employer not found with id: " + requestDTO.getEmployerId()));
        
        JobData job = jobMapper.toEntity(requestDTO, employer);
        JobData savedJob = jobRepository.save(job);
        return jobMapper.toResponseDTO(savedJob);
    }
    
    public JobResponseDTO getJobById(Long id) {
        JobData job = jobRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        return jobMapper.toResponseDTO(job);
    }
    
    public List<JobResponseDTO> getJobsByEmployerId(Long employerId) {
        return jobRepository.findByEmployerId(employerId).stream()
            .map(jobMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<JobResponseDTO> getJobsByStatus(String status) {
        return jobRepository.findByStatus(status).stream()
            .map(jobMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<JobResponseDTO> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location).stream()
            .map(jobMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll().stream()
            .map(jobMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public JobResponseDTO updateJob(Long id, JobRequestDTO requestDTO) {
        JobData existingJob = jobRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        
        existingJob.setTitle(requestDTO.getTitle());
        existingJob.setDescription(requestDTO.getDescription());
        existingJob.setLocation(requestDTO.getLocation());
        existingJob.setSalaryRange(requestDTO.getSalaryRange());
        existingJob.setStartDate(requestDTO.getStartDate());
        existingJob.setEndDate(requestDTO.getEndDate());
        existingJob.setFullTime(requestDTO.getFullTime());
        existingJob.setRemoteAllowed(requestDTO.getRemoteAllowed());
        existingJob.setStatus(requestDTO.getStatus());
        
        JobData updatedJob = jobRepository.save(existingJob);
        return jobMapper.toResponseDTO(updatedJob);
    }
    
    public void deleteJob(Long id) {
        if (!jobRepository.findById(id).isPresent()) {
            throw new RuntimeException("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }
}
