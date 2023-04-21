package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.dto.HomeRequest;
import com.portfolio.GabrielMotta.dto.ProfileRequest;
import com.portfolio.GabrielMotta.model.Education;
import com.portfolio.GabrielMotta.model.Experience;
import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.model.Project;
import com.portfolio.GabrielMotta.model.Service;
import com.portfolio.GabrielMotta.model.Skill;
import com.portfolio.GabrielMotta.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("per")
public class PersonController {
    
    @Autowired
    private IPersonService persServ;
    
//    @PostMapping("/new")
//    public void addPerson (@RequestBody Person per){
//        persServ.createPerson(per);
//    }
//    
//    @GetMapping ("/bring")
//    @ResponseBody
//    public List<Person>bringPersons(){
//        return persServ.findPersons();
//    }
    
    @GetMapping ("/bringHome/{id}")
    @ResponseBody
    public HomeRequest bringHome (@PathVariable Long id){
        Person per = this.persServ.findPerson(id);
        HomeRequest home = new HomeRequest();
        home.setTitle(per.getTitle());
        home.setDescription(per.getDescrition());
        home.setPhone(per.getPhone());
        
        return home;
    }
    
    @GetMapping ("/bringProf/{id}")
    @ResponseBody
    public ProfileRequest bringProfile (@PathVariable Long id){
        Person per = this.persServ.findPerson(id);
        ProfileRequest prof = new ProfileRequest();
        prof.setImg(per.getFoto());
        prof.setName(per.getName());
        
        return prof;
    }
    
    @PostMapping ("/newEdu/{idPer}")
    public void addEducation (@PathVariable Long idPer, @RequestBody Education edu){
        Person per = this.persServ.findPerson(idPer);
        per.addEducation(edu);
        this.persServ.updatePerson(per);
    }
    
    @PostMapping ("/newExp/{idPer}")
    public void addExperience (@PathVariable Long idPer, @RequestBody Experience exp){
        Person per = this.persServ.findPerson(idPer);
        per.addExperience(exp);
        this.persServ.updatePerson(per);
    }
    
    @PostMapping ("/newPro/{idPer}")
    public void addProject (@PathVariable Long idPer, @RequestBody Project pro){
        Person per = this.persServ.findPerson(idPer);
        per.addProject(pro);
        this.persServ.updatePerson(per);
    }
    
    @PostMapping ("/newServ/{idPer}")
    public void addService (@PathVariable Long idPer, @RequestBody Service ser){
        Person per = this.persServ.findPerson(idPer);
        per.addService(ser);
        this.persServ.updatePerson(per);
    }
    
    @PostMapping ("/newSkill/{idPer}")
    public void addSkill (@PathVariable Long idPer, @RequestBody Skill ski){
        Person per = this.persServ.findPerson(idPer);
        per.addSkill(ski);
        this.persServ.updatePerson(per);
    }
    
    @PutMapping ("/updateHome/{id}")
    public void updatePerson (@PathVariable Long id, @RequestBody HomeRequest home){
        Person per = this.persServ.findPerson(id);
        per.setTitle(home.getTitle());
        per.setDescrition(home.getDescription());
        per.setPhone(home.getPhone());
        this.persServ.updatePerson(per);
    }
    
}
