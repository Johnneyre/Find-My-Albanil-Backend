package com.my_find_albanil.demo.infraestructure.driven_adapters.post.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.post.PostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostDataRepository extends JpaRepository<PostData, Long> {
    @Query("SELECT p FROM PostData p WHERE p.author.id = :authorId")
    List<PostData> findByAuthorId(UUID authorId);
}
