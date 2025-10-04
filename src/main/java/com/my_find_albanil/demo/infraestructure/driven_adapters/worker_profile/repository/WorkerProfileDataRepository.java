package com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkerProfileDataRepository extends JpaRepository<WorkerProfileData, Long> {
    @Query("SELECT w FROM WorkerProfileData w WHERE w.user.id = :userId")
    Optional<WorkerProfileData> findByUserId(UUID userId);
    List<WorkerProfileData> findByTrade(String trade);
    List<WorkerProfileData> findByAvailability(Boolean availability);
}
