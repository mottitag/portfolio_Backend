
package com.portfolio.GabrielMotta.repository;

import com.portfolio.GabrielMotta.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long>{
    
}
