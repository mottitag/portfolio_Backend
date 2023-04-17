package com.portfolio.GabrielMotta.repository;

import com.portfolio.GabrielMotta.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    
}
