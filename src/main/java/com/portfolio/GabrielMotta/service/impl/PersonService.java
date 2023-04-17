package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.repository.PersonRepository;
import com.portfolio.GabrielMotta.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService{
    
    @Autowired
    public PersonRepository persRepo;

    @Override
    public List<Person> findPersons() {
        return persRepo.findAll();
    }

    @Override
    public void createPerson(Person per) {
        persRepo.save(per);
    }
    
    @Override
    public void updatePerson(Person per){
        persRepo.save(per);
    }

    @Override
    public void deletePerson(Long id) {
        persRepo.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        return persRepo.findById(id).orElse(null);
    }
    
}
