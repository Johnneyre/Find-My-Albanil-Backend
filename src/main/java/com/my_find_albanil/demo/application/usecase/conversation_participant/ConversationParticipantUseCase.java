package com.my_find_albanil.demo.application.usecase.conversation_participant;

import com.my_find_albanil.demo.application.mapper.ConversationParticipantMapper;
import com.my_find_albanil.demo.domain.models.request.conversation_participant.ConversationParticipantRequestDTO;
import com.my_find_albanil.demo.domain.models.response.conversation_participant.ConversationParticipantResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.ConversationParticipantData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.repository.ConversationParticipantDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.repository.ConversationDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationParticipantUseCase {
    
    private final ConversationParticipantDataRepository participantRepository;
    private final ConversationDataRepository conversationRepository;
    private final UserDataRepository userRepository;
    private final ConversationParticipantMapper participantMapper;
    
    public ConversationParticipantResponseDTO addParticipant(ConversationParticipantRequestDTO requestDTO) {
        ConversationData conversation = conversationRepository.findById(requestDTO.getConversationId())
            .orElseThrow(() -> new RuntimeException("Conversation not found with id: " + requestDTO.getConversationId()));
        
        UserData user = userRepository.findById(requestDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getUserId()));
        
        ConversationParticipantData participant = participantMapper.toEntity(requestDTO, conversation, user);
        ConversationParticipantData savedParticipant = participantRepository.save(participant);
        return participantMapper.toResponseDTO(savedParticipant);
    }
    
    public ConversationParticipantResponseDTO getParticipantById(Long id) {
        ConversationParticipantData participant = participantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Participant not found with id: " + id));
        return participantMapper.toResponseDTO(participant);
    }
    
    public List<ConversationParticipantResponseDTO> getParticipantsByConversationId(Long conversationId) {
        return participantRepository.findByConversationId(conversationId).stream()
            .map(participantMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<ConversationParticipantResponseDTO> getParticipantsByUserId(UUID userId) {
        return participantRepository.findByUserId(userId).stream()
            .map(participantMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public void removeParticipant(Long id) {
        if (!participantRepository.findById(id).isPresent()) {
            throw new RuntimeException("Participant not found with id: " + id);
        }
        participantRepository.deleteById(id);
    }
}
