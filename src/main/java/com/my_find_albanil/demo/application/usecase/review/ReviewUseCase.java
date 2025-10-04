package com.my_find_albanil.demo.application.usecase.review;

import com.my_find_albanil.demo.application.mapper.ReviewMapper;
import com.my_find_albanil.demo.domain.models.request.review.ReviewRequestDTO;
import com.my_find_albanil.demo.domain.models.response.review.ReviewResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.review.ReviewData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.review.repository.ReviewDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewUseCase {
    
    private final ReviewDataRepository reviewRepository;
    private final UserDataRepository userRepository;
    private final ReviewMapper reviewMapper;
    
    public ReviewResponseDTO createReview(ReviewRequestDTO requestDTO) {
        UserData reviewer = userRepository.findById(requestDTO.getReviewerId())
            .orElseThrow(() -> new RuntimeException("Reviewer not found with id: " + requestDTO.getReviewerId()));
        
        UserData target = userRepository.findById(requestDTO.getTargetId())
            .orElseThrow(() -> new RuntimeException("Target user not found with id: " + requestDTO.getTargetId()));
        
        ReviewData review = reviewMapper.toEntity(requestDTO, reviewer, target);
        ReviewData savedReview = reviewRepository.save(review);
        return reviewMapper.toResponseDTO(savedReview);
    }
    
    public ReviewResponseDTO getReviewById(Long id) {
        ReviewData review = reviewRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        return reviewMapper.toResponseDTO(review);
    }
    
    public List<ReviewResponseDTO> getReviewsByReviewerId(UUID reviewerId) {
        return reviewRepository.findByReviewerId(reviewerId).stream()
            .map(reviewMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<ReviewResponseDTO> getReviewsByTargetId(UUID targetId) {
        return reviewRepository.findByTargetId(targetId).stream()
            .map(reviewMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public void deleteReview(Long id) {
        if (!reviewRepository.findById(id).isPresent()) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }
}
