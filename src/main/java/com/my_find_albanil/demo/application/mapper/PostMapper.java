package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.post.PostRequestDTO;
import com.my_find_albanil.demo.domain.models.response.post.PostResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.post.PostData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    
    public PostData toEntity(PostRequestDTO dto, UserData author) {
        if (dto == null) return null;
        
        PostData entity = new PostData();
        entity.setId(dto.getId());
        entity.setAuthor(author);
        entity.setContent(dto.getContent());
        entity.setMediaUrl(dto.getMediaUrl());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
    
    public PostResponseDTO toResponseDTO(PostData entity) {
        if (entity == null) return null;
        
        return new PostResponseDTO(
            entity.getId(),
            entity.getAuthor() != null ? entity.getAuthor().getId() : null,
            entity.getContent(),
            entity.getMediaUrl(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
