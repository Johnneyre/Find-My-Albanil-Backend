package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.conversation_participant.ConversationParticipantUseCase;
import com.my_find_albanil.demo.domain.models.request.conversation_participant.ConversationParticipantRequestDTO;
import com.my_find_albanil.demo.domain.models.response.conversation_participant.ConversationParticipantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/conversation-participants")
@RequiredArgsConstructor
public class ConversationParticipantController {
    
    private final ConversationParticipantUseCase participantUseCase;
    
    @PostMapping
    public ResponseEntity<ConversationParticipantResponseDTO> addParticipant(@RequestBody ConversationParticipantRequestDTO requestDTO) {
        ConversationParticipantResponseDTO response = participantUseCase.addParticipant(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ConversationParticipantResponseDTO> getParticipantById(@PathVariable Long id) {
        ConversationParticipantResponseDTO response = participantUseCase.getParticipantById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/conversation/{conversationId}")
    public ResponseEntity<List<ConversationParticipantResponseDTO>> getParticipantsByConversationId(@PathVariable Long conversationId) {
        List<ConversationParticipantResponseDTO> response = participantUseCase.getParticipantsByConversationId(conversationId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ConversationParticipantResponseDTO>> getParticipantsByUserId(@PathVariable UUID userId) {
        List<ConversationParticipantResponseDTO> response = participantUseCase.getParticipantsByUserId(userId);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeParticipant(@PathVariable Long id) {
        participantUseCase.removeParticipant(id);
        return ResponseEntity.noContent().build();
    }
}
