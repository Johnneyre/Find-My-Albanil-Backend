package com.my_find_albanil.demo.domain.models.response.worker_profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerProfileResponseDTO {
    private Long id;
    private UUID userId;
    private String trade;
    private Integer experienceYears;
    private BigDecimal hourlyRate;
    private Boolean availability;
    private String gear;
    private String certifications;
    private String resumeUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
