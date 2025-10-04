package com.my_find_albanil.demo.domain.models.request.worker_profile;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerProfileRequestDTO {
    private Long id;
    
    @NotNull(message = "User ID is required")
    private UUID userId;
    
    @NotBlank(message = "Trade is required")
    @Size(max = 100, message = "Trade must not exceed 100 characters")
    private String trade;
    
    @Min(value = 0, message = "Experience years must be at least 0")
    @Max(value = 50, message = "Experience years must not exceed 50")
    private Integer experienceYears;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Hourly rate must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Hourly rate must have at most 8 integer digits and 2 decimal places")
    private BigDecimal hourlyRate;
    
    private Boolean availability;
    private String gear;
    private String certifications;
    private String resumeUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
