package com.my_find_albanil.demo.domain.models.request.job;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDTO {
    private Long id;
    
    @NotNull(message = "Employer ID is required")
    private Long employerId;
    
    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;
    
    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    private String description;
    
    @NotBlank(message = "Location is required")
    private String location;
    
    private String salaryRange;
    
    @Future(message = "Start date must be in the future")
    private LocalDateTime startDate;
    
    private LocalDateTime endDate;
    private Boolean fullTime;
    private Boolean remoteAllowed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @Pattern(regexp = "open|closed|paused", message = "Status must be open, closed, or paused")
    private String status;
}
