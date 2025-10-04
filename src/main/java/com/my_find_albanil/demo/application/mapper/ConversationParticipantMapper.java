package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.conversation_participant.ConversationParticipantRequestDTO;
import com.my_find_albanil.demo.domain.models.response.conversation_participant.ConversationParticipantResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.ConversationParticipantData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class ConversationParticipantMapper {
    
    public ConversationParticipantData toEntity(ConversationParticipantRequestDTO dto, ConversationData conversation, UserData user) {
        if (dto == null) return null;
        
        ConversationParticipantData entity = new ConversationParticipantData();
        entity.setId(dto.getId());
        entity.setConversation(conversation);
        entity.setUser(user);
        return entity;
    }
    
    public ConversationParticipantResponseDTO toResponseDTO(ConversationParticipantData entity) {
        if (entity == null) return null;
        
        return new ConversationParticipantResponseDTO(
            entity.getId(),
            entity.getConversation() != null ? entity.getConversation().getId() : null,
            entity.getUser() != null ? entity.getUser().getId() : null
        );
    }
}
