
package com.portfolio.GabrielMotta.repository;

import com.portfolio.GabrielMotta.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository <Service, Long>{
    
}
