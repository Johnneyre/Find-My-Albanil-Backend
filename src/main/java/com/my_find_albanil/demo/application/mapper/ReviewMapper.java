package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.review.ReviewRequestDTO;
import com.my_find_albanil.demo.domain.models.response.review.ReviewResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.review.ReviewData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    
    public ReviewData toEntity(ReviewRequestDTO dto, UserData reviewer, UserData target) {
        if (dto == null) return null;
        
        ReviewData entity = new ReviewData();
        entity.setId(dto.getId());
        entity.setReviewer(reviewer);
        entity.setTarget(target);
        entity.setRating(dto.getRating());
        entity.setTitle(dto.getTitle());
        entity.setBody(dto.getBody());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
    
    public ReviewResponseDTO toResponseDTO(ReviewData entity) {
        if (entity == null) return null;
        
        return new ReviewResponseDTO(
            entity.getId(),
            entity.getReviewer() != null ? entity.getReviewer().getId() : null,
            entity.getTarget() != null ? entity.getTarget().getId() : null,
            entity.getRating(),
            entity.getTitle(),
            entity.getBody(),
            entity.getCreatedAt()
        );
    }
}
