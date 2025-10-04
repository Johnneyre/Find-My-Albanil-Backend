package com.my_find_albanil.demo.domain.models.request.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDTO {
    private Long id;
    private Long jobId;
    private Long workerProfileId;
    private String coverLetter;
    private BigDecimal proposedRate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
