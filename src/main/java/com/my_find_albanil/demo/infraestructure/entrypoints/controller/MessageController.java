package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.message.MessageUseCase;
import com.my_find_albanil.demo.domain.models.request.message.MessageRequestDTO;
import com.my_find_albanil.demo.domain.models.response.message.MessageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    
    private final MessageUseCase messageUseCase;
    
    @PostMapping
    public ResponseEntity<MessageResponseDTO> createMessage(@RequestBody MessageRequestDTO requestDTO) {
        MessageResponseDTO response = messageUseCase.createMessage(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> getMessageById(@PathVariable Long id) {
        MessageResponseDTO response = messageUseCase.getMessageById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/conversation/{conversationId}")
    public ResponseEntity<List<MessageResponseDTO>> getMessagesByConversationId(@PathVariable Long conversationId) {
        List<MessageResponseDTO> response = messageUseCase.getMessagesByConversationId(conversationId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/sender/{senderId}")
    public ResponseEntity<List<MessageResponseDTO>> getMessagesBySenderId(@PathVariable UUID senderId) {
        List<MessageResponseDTO> response = messageUseCase.getMessagesBySenderId(senderId);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageUseCase.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
