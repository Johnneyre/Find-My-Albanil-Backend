// UserRepository.java
package com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDataRepository {
    Optional<UserData> findById(UUID id);
    Optional<UserData> findByEmail(String email);
    UserData save(UserData user);
    void deleteById(UUID id);
    boolean existsByEmail(String email);
}