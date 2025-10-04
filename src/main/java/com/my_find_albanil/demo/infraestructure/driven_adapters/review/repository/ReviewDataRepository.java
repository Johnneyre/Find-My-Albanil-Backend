package com.my_find_albanil.demo.infraestructure.driven_adapters.review.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.review.ReviewData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewDataRepository {
    Optional<ReviewData> findById(Long id);
    List<ReviewData> findByReviewerId(UUID reviewerId);
    List<ReviewData> findByTargetId(UUID targetId);
    Optional<ReviewData> findByReviewerIdAndTargetId(UUID reviewerId, UUID targetId);
    ReviewData save(ReviewData review);
    void deleteById(Long id);
    List<ReviewData> findAll();
}
