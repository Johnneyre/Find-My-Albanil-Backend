package com.my_find_albanil.demo.application.mapper;

import com.my_find_albanil.demo.domain.models.request.message.MessageRequestDTO;
import com.my_find_albanil.demo.domain.models.response.message.MessageResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.message.MessageData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    
    public MessageData toEntity(MessageRequestDTO dto, ConversationData conversation, UserData sender) {
        if (dto == null) return null;
        
        MessageData entity = new MessageData();
        entity.setId(dto.getId());
        entity.setConversation(conversation);
        entity.setSender(sender);
        entity.setBody(dto.getBody());
        entity.setSentAt(dto.getSentAt());
        return entity;
    }
    
    public MessageResponseDTO toResponseDTO(MessageData entity) {
        if (entity == null) return null;
        
        return new MessageResponseDTO(
            entity.getId(),
            entity.getConversation() != null ? entity.getConversation().getId() : null,
            entity.getSender() != null ? entity.getSender().getId() : null,
            entity.getBody(),
            entity.getSentAt()
        );
    }
}
