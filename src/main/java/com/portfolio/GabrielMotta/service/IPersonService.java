package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.model.Person;
import java.util.List;


public interface IPersonService {
    
    public List<Person> findPersons ();
    public void createPerson (Person per);
    public void deletePerson (Long id);
    public Person findPerson (Long id);
    
}
