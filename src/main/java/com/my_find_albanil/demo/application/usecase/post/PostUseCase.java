package com.my_find_albanil.demo.application.usecase.post;

import com.my_find_albanil.demo.application.mapper.PostMapper;
import com.my_find_albanil.demo.domain.models.request.post.PostRequestDTO;
import com.my_find_albanil.demo.domain.models.response.post.PostResponseDTO;
import com.my_find_albanil.demo.infraestructure.driven_adapters.post.PostData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.post.repository.PostDataRepository;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostUseCase {
    
    private final PostDataRepository postRepository;
    private final UserDataRepository userRepository;
    private final PostMapper postMapper;
    
    public PostResponseDTO createPost(PostRequestDTO requestDTO) {
        UserData author = userRepository.findById(requestDTO.getAuthorId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getAuthorId()));
        
        PostData post = postMapper.toEntity(requestDTO, author);
        PostData savedPost = postRepository.save(post);
        return postMapper.toResponseDTO(savedPost);
    }
    
    public PostResponseDTO getPostById(Long id) {
        PostData post = postRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        return postMapper.toResponseDTO(post);
    }
    
    public List<PostResponseDTO> getPostsByAuthorId(UUID authorId) {
        return postRepository.findByAuthorId(authorId).stream()
            .map(postMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll().stream()
            .map(postMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    public PostResponseDTO updatePost(Long id, PostRequestDTO requestDTO) {
        PostData existingPost = postRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        
        existingPost.setContent(requestDTO.getContent());
        existingPost.setMediaUrl(requestDTO.getMediaUrl());
        
        PostData updatedPost = postRepository.save(existingPost);
        return postMapper.toResponseDTO(updatedPost);
    }
    
    public void deletePost(Long id) {
        if (!postRepository.findById(id).isPresent()) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        postRepository.deleteById(id);
    }
}
