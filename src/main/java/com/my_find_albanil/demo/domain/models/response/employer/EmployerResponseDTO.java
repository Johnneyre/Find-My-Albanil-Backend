package com.my_find_albanil.demo.domain.models.response.employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponseDTO {
    private Long id;
    private UUID userId;
    private String companyName;
    private String companyDescription;
    private String companyLogoUrl;
    private String website;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
