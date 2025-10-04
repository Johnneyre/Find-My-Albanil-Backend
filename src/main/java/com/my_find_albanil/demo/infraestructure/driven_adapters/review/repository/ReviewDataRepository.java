package com.my_find_albanil.demo.infraestructure.driven_adapters.review.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.review.ReviewData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewDataRepository extends JpaRepository<ReviewData, Long> {
    @Query("SELECT r FROM ReviewData r WHERE r.reviewer.id = :reviewerId")
    List<ReviewData> findByReviewerId(UUID reviewerId);
    
    @Query("SELECT r FROM ReviewData r WHERE r.target.id = :targetId")
    List<ReviewData> findByTargetId(UUID targetId);
    
    @Query("SELECT r FROM ReviewData r WHERE r.reviewer.id = :reviewerId AND r.target.id = :targetId")
    Optional<ReviewData> findByReviewerIdAndTargetId(UUID reviewerId, UUID targetId);
}
