package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.dto.SkillRequest;
import com.portfolio.GabrielMotta.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List<Skill> findSkills ();
    public void createSkill (SkillRequest skiReq);
    public void updateSkill (SkillRequest skiReq);
    public void deleteSkill (Long id);
    public Skill findSkill (Long id);
    
}
