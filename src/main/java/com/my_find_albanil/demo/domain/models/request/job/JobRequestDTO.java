package com.my_find_albanil.demo.domain.models.request.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDTO {
    private Long id;
    private Long employerId;
    private String title;
    private String description;
    private String location;
    private String salaryRange;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean fullTime;
    private Boolean remoteAllowed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
}
