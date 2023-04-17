
package com.portfolio.GabrielMotta.repository;

import com.portfolio.GabrielMotta.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository <Education, Long>{
    
}
