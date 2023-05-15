package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.model.Education;
import com.portfolio.GabrielMotta.service.IEducationService;
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
@RequestMapping("edu")
@CrossOrigin(origins = "https://porfolio-mottita.web.app")
public class EducationController {
    
    @Autowired
    private IEducationService eduServ;
    
    @GetMapping("/bring")
    @ResponseBody
    public List<Education>bringEducation(){
        return this.eduServ.findEducations();
    }
    
    @DeleteMapping("/del/{id}")
    public void deleteEducation(@PathVariable Long id){
        this.eduServ.deleteEducation(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateEducation(@PathVariable Long id,
            @RequestBody Education edu){
        Education updateEdu = this.eduServ.findEducation(id);
        
        BeanUtils.copyProperties(edu, updateEdu);
        
        this.eduServ.updateEducation(updateEdu);
    }
    
}
