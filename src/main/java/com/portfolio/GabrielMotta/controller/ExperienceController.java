package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.model.Experience;
import com.portfolio.GabrielMotta.service.IExperienceService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exp")
@CrossOrigin(origins = "https://porfolio-mottita.web.app")
public class ExperienceController {
    
    @Autowired
    private IExperienceService expServ;
    
   @GetMapping("/bring")
    @ResponseBody
    public List<Experience> bringExperiences(){
        return this.expServ.findExperiences();
    }
    
    @DeleteMapping("/del/{id}")
    public void deleteExperience(@PathVariable Long id){
        this.expServ.deleteExperience(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateExperience(@PathVariable Long id,
            @RequestBody Experience exp){
        
        Experience updateExp = this.expServ.findExperience(id);
        BeanUtils.copyProperties(exp, updateExp);
        
        this.expServ.updaateExperience(updateExp);
        
    }
    
}
