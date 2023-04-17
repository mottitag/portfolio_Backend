package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.dto.ExperienceRequest;
import com.portfolio.GabrielMotta.model.Experience;
import java.util.List;


public interface IExperienceService {
    
    public List<Experience> findExperiences ();
    public void createExperience (ExperienceRequest expReq);
    public void updaateExperience (Experience exp);
    public void deleteExperience (Long id);
    public Experience findExperience (Long id);
    
}
