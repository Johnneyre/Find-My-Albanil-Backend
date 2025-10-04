package com.my_find_albanil.demo.infraestructure.entrypoints.controller;

import com.my_find_albanil.demo.application.usecase.post.PostUseCase;
import com.my_find_albanil.demo.domain.models.request.post.PostRequestDTO;
import com.my_find_albanil.demo.domain.models.response.post.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    
    private final PostUseCase postUseCase;
    
    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO response = postUseCase.createPost(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        PostResponseDTO response = postUseCase.getPostById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<PostResponseDTO>> getPostsByAuthorId(@PathVariable UUID authorId) {
        List<PostResponseDTO> response = postUseCase.getPostsByAuthorId(authorId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        List<PostResponseDTO> response = postUseCase.getAllPosts();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Long id, @RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO response = postUseCase.updatePost(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postUseCase.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
