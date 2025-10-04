package com.my_find_albanil.demo.domain.models.request.review;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {
    private Long id;
    
    @NotNull(message = "Reviewer ID is required")
    private UUID reviewerId;
    
    @NotNull(message = "Target ID is required")
    private UUID targetId;
    
    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must not exceed 5")
    private Short rating;
    
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;
    
    @Size(max = 2000, message = "Body must not exceed 2000 characters")
    private String body;
    
    private LocalDateTime createdAt;
}
