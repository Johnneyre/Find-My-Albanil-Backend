package com.my_find_albanil.demo.infraestructure.driven_adapters.job.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDataRepository extends JpaRepository<JobData, Long> {
    @Query("SELECT j FROM JobData j WHERE j.employer.id = :employerId")
    List<JobData> findByEmployerId(Long employerId);
    
    List<JobData> findByStatus(String status);
    List<JobData> findByLocation(String location);
}
