package com.my_find_albanil.demo.domain.models.request.review;

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
    private UUID reviewerId;
    private UUID targetId;
    private Short rating;
    private String title;
    private String body;
    private LocalDateTime createdAt;
}
