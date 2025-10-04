package com.my_find_albanil.demo.application.usecase.employer;

import com.my_find_albanil.demo.application.mapper.EmployerMapper;
import com.my_find_albanil.demo.domain.models.request.employer.EmployerRequestDTO;
import com.my_find_albanil.demo.domain.models.response.employer.EmployerResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.repository.EmployerDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerUseCase {
    
    private final EmployerDataRepository employerRepository;
    private final UserDataRepository userRepository;
    private final EmployerMapper employerMapper;
    
    public EmployerResponseDTO createEmployer(EmployerRequestDTO requestDTO) {
        UserData user = userRepository.findById(requestDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getUserId()));
        
        EmployerData employer = employerMapper.toEntity(requestDTO, user);
        EmployerData savedEmployer = employerRepository.save(employer);
        return employerMapper.toResponseDTO(savedEmployer);
    }
    
    public EmployerResponseDTO getEmployerById(Long id) {
        EmployerData employer = employerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employer not found with id: " + id));
        return employerMapper.toResponseDTO(employer);
    }
    
    public EmployerResponseDTO getEmployerByUserId(UUID userId) {
        EmployerData employer = employerRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Employer not found for user id: " + userId));
        return employerMapper.toResponseDTO(employer);
    }
    
    public List<EmployerResponseDTO> getAllEmployers() {
        return employerRepository.findAll().stream()
            .map(employerMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public EmployerResponseDTO updateEmployer(Long id, EmployerRequestDTO requestDTO) {
        EmployerData existingEmployer = employerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employer not found with id: " + id));
        
        existingEmployer.setCompanyName(requestDTO.getCompanyName());
        existingEmployer.setCompanyDescription(requestDTO.getCompanyDescription());
        existingEmployer.setCompanyLogoUrl(requestDTO.getCompanyLogoUrl());
        existingEmployer.setWebsite(requestDTO.getWebsite());
        
        EmployerData updatedEmployer = employerRepository.save(existingEmployer);
        return employerMapper.toResponseDTO(updatedEmployer);
    }
    
    public void deleteEmployer(Long id) {
        if (!employerRepository.findById(id).isPresent()) {
            throw new RuntimeException("Employer not found with id: " + id);
        }
        employerRepository.deleteById(id);
    }
}
