package com.my_find_albanil.demo.application.usecase.message;

import com.my_find_albanil.demo.application.mapper.MessageMapper;
import com.my_find_albanil.demo.domain.models.request.message.MessageRequestDTO;
import com.my_find_albanil.demo.domain.models.response.message.MessageResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.message.MessageData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.message.repository.MessageDataRepository;
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
public class MessageUseCase {
    
    private final MessageDataRepository messageRepository;
    private final ConversationDataRepository conversationRepository;
    private final UserDataRepository userRepository;
    private final MessageMapper messageMapper;
    
    public MessageResponseDTO createMessage(MessageRequestDTO requestDTO) {
        ConversationData conversation = conversationRepository.findById(requestDTO.getConversationId())
            .orElseThrow(() -> new RuntimeException("Conversation not found with id: " + requestDTO.getConversationId()));
        
        UserData sender = userRepository.findById(requestDTO.getSenderId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getSenderId()));
        
        MessageData message = messageMapper.toEntity(requestDTO, conversation, sender);
        MessageData savedMessage = messageRepository.save(message);
        return messageMapper.toResponseDTO(savedMessage);
    }
    
    public MessageResponseDTO getMessageById(Long id) {
        MessageData message = messageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
        return messageMapper.toResponseDTO(message);
    }
    
    public List<MessageResponseDTO> getMessagesByConversationId(Long conversationId) {
        return messageRepository.findByConversationId(conversationId).stream()
            .map(messageMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<MessageResponseDTO> getMessagesBySenderId(UUID senderId) {
        return messageRepository.findBySenderId(senderId).stream()
            .map(messageMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public void deleteMessage(Long id) {
        if (!messageRepository.findById(id).isPresent()) {
            throw new RuntimeException("Message not found with id: " + id);
        }
        messageRepository.deleteById(id);
    }
}
