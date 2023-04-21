package com.portfolio.GabrielMotta.service.impl;

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

    @Override
    public List<Skill> findSkills() {
        return skiRepo.findAll();
    }

    @Override
    public void updateSkill(Skill skill){
        Skill updateSkill = this.findSkill(skill.getId());
        BeanUtils.copyProperties(skill, updateSkill);
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
