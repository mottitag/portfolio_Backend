package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.dto.SkillRequest;
import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.model.Skill;
import com.portfolio.GabrielMotta.repository.SkillRepository;
import com.portfolio.GabrielMotta.service.ISkillService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository skiRepo;
    private PersonService perServ;

    @Override
    public List<Skill> findSkills() {
        return skiRepo.findAll();
    }

    @Override
    public void createSkill(SkillRequest skiReq) {
        Skill newSkill = new Skill();
        BeanUtils.copyProperties(skiReq, newSkill);
        
        Person per = this.perServ.findPerson(skiReq.getPersonId());
        per.addSkill(newSkill);
        this.perServ.updatePerson(per);
    }
    
    @Override
    public void updateSkill(SkillRequest skiReq){
        Skill updateSkill = this.findSkill(skiReq.getId());
        BeanUtils.copyProperties(skiReq, updateSkill);
        this.skiRepo.save(updateSkill);
    }

    @Override
    public void deleteSkill(Long id) {
        skiRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        return skiRepo.findById(id).orElse(null);
    }
    
}
