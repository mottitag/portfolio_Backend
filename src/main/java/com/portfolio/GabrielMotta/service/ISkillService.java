package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List<Skill> findSkills ();
    public void updateSkill (Skill skiReq);
    public void deleteSkill (Long id);
    public Skill findSkill (Long id);
    
}
