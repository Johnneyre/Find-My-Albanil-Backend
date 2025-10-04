package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.review.ReviewUseCase;
import com.my_find_albanil.demo.domain.models.request.review.ReviewRequestDTO;
import com.my_find_albanil.demo.domain.models.response.review.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    
    private final ReviewUseCase reviewUseCase;
    
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO requestDTO) {
        ReviewResponseDTO response = reviewUseCase.createReview(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> getReviewById(@PathVariable Long id) {
        ReviewResponseDTO response = reviewUseCase.getReviewById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/reviewer/{reviewerId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByReviewerId(@PathVariable UUID reviewerId) {
        List<ReviewResponseDTO> response = reviewUseCase.getReviewsByReviewerId(reviewerId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/target/{targetId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByTargetId(@PathVariable UUID targetId) {
        List<ReviewResponseDTO> response = reviewUseCase.getReviewsByTargetId(targetId);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewUseCase.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
