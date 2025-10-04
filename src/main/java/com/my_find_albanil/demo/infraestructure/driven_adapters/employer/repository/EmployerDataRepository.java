package com.my_find_albanil.demo.infraestructure.driven_adapters.employer.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployerDataRepository extends JpaRepository<EmployerData, Long> {
    @Query("SELECT e FROM EmployerData e WHERE e.user.id = :userId")
    Optional<EmployerData> findByUserId(UUID userId);
    List<EmployerData> findByCompanyName(String companyName);
}
