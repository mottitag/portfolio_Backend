package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private IPersonService persServ;
    
    @PostMapping("/new/person")
    public void addPerson (@RequestBody Person per){
        persServ.createPerson(per);
    }
    
    @GetMapping ("/ver/person")
    @ResponseBody
    public List<Person>bringPersons(){
        return persServ.findPersons();
    }
    
}
