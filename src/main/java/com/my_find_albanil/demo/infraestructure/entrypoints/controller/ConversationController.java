package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.conversation.ConversationUseCase;
import com.my_find_albanil.demo.domain.models.request.conversation.ConversationRequestDTO;
import com.my_find_albanil.demo.domain.models.response.conversation.ConversationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {
    
    private final ConversationUseCase conversationUseCase;
    
    @PostMapping
    public ResponseEntity<ConversationResponseDTO> createConversation(@RequestBody ConversationRequestDTO requestDTO) {
        ConversationResponseDTO response = conversationUseCase.createConversation(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ConversationResponseDTO> getConversationById(@PathVariable Long id) {
        ConversationResponseDTO response = conversationUseCase.getConversationById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<ConversationResponseDTO>> getAllConversations() {
        List<ConversationResponseDTO> response = conversationUseCase.getAllConversations();
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConversation(@PathVariable Long id) {
        conversationUseCase.deleteConversation(id);
        return ResponseEntity.noContent().build();
    }
}
