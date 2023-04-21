package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.model.Skill;
import com.portfolio.GabrielMotta.service.ISkillService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
public class SkillController {
    
    @Autowired
    private ISkillService skillServ;    
    
    @GetMapping("/bring")
    @ResponseBody
    public List<Skill> bringServices (){
        return this.skillServ.findSkills();
    }
        
    @DeleteMapping("/del/{id}")
    public void deleteService(@PathVariable Long id){
        this.skillServ.deleteSkill(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateService(@PathVariable Long id,
            @RequestBody Skill serv){
        Skill updateSkill = this.skillServ.findSkill(id);
        BeanUtils.copyProperties(serv, updateSkill);
        this.skillServ.updateSkill(updateSkill);
    }
}
