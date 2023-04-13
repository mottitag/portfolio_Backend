package com.portfolio.GabrielMotta.repository;

import com.portfolio.GabrielMotta.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{
    
}
