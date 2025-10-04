package com.my_find_albanil.demo.infraestructure.driven_adapters.post.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.post.PostData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostDataRepository {
    Optional<PostData> findById(Long id);
    List<PostData> findByAuthorId(UUID authorId);
    PostData save(PostData post);
    void deleteById(Long id);
    List<PostData> findAll();
}
