// UserRepository.java
package com.my_find_albanil.demo.infraestructure.driven_adapters.user.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, UUID> {
    Optional<UserData> findByEmail(String email);
    boolean existsByEmail(String email);
}