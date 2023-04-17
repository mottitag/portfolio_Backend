
package com.portfolio.GabrielMotta.repository;

import com.portfolio.GabrielMotta.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
    
}
