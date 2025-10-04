package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.conversation.ConversationRequestDTO;
import com.my_find_albanil.demo.domain.models.response.conversation.ConversationResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import org.springframework.stereotype.Component;

@Component
public class ConversationMapper {
    
    public ConversationData toEntity(ConversationRequestDTO dto) {
        if (dto == null) return null;
        
        ConversationData entity = new ConversationData();
        entity.setId(dto.getId());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
    
    public ConversationResponseDTO toResponseDTO(ConversationData entity) {
        if (entity == null) return null;
        
        return new ConversationResponseDTO(
            entity.getId(),
            entity.getCreatedAt()
        );
    }
}
