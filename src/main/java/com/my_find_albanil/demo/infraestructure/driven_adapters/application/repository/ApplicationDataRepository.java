package com.my_find_albanil.demo.infraestructure.driven_adapters.application.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.application.ApplicationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationDataRepository extends JpaRepository<ApplicationData, Long> {
    @Query("SELECT a FROM ApplicationData a WHERE a.job.id = :jobId")
    List<ApplicationData> findByJobId(Long jobId);
    
    @Query("SELECT a FROM ApplicationData a WHERE a.workerProfile.id = :workerProfileId")
    List<ApplicationData> findByWorkerProfileId(Long workerProfileId);
    
    @Query("SELECT a FROM ApplicationData a WHERE a.job.id = :jobId AND a.workerProfile.id = :workerProfileId")
    Optional<ApplicationData> findByJobIdAndWorkerProfileId(Long jobId, Long workerProfileId);
    
    List<ApplicationData> findByStatus(String status);
}
