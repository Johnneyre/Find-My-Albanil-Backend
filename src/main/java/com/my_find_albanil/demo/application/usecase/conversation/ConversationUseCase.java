package com.my_find_albanil.demo.application.usecase.conversation;

import com.my_find_albanil.demo.application.mapper.ConversationMapper;
import com.my_find_albanil.demo.domain.models.request.conversation.ConversationRequestDTO;
import com.my_find_albanil.demo.domain.models.response.conversation.ConversationResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.repository.ConversationDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationUseCase {
    
    private final ConversationDataRepository conversationRepository;
    private final ConversationMapper conversationMapper;
    
    public ConversationResponseDTO createConversation(ConversationRequestDTO requestDTO) {
        ConversationData conversation = conversationMapper.toEntity(requestDTO);
        ConversationData savedConversation = conversationRepository.save(conversation);
        return conversationMapper.toResponseDTO(savedConversation);
    }
    
    public ConversationResponseDTO getConversationById(Long id) {
        ConversationData conversation = conversationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Conversation not found with id: " + id));
        return conversationMapper.toResponseDTO(conversation);
    }
    
    public List<ConversationResponseDTO> getAllConversations() {
        return conversationRepository.findAll().stream()
            .map(conversationMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public void deleteConversation(Long id) {
        if (!conversationRepository.findById(id).isPresent()) {
            throw new RuntimeException("Conversation not found with id: " + id);
        }
        conversationRepository.deleteById(id);
    }
}
