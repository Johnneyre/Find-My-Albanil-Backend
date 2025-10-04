package com.my_find_albanil.demo.infraestructure.driven_adapters.skill.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillDataRepository extends JpaRepository<SkillData, Long> {
    Optional<SkillData> findByName(String name);
    boolean existsByName(String name);
}
