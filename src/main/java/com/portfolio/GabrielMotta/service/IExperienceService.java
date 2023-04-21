package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.model.Experience;
import java.util.List;


public interface IExperienceService {
    
    public List<Experience> findExperiences ();
    public void updaateExperience (Experience exp);
    public void deleteExperience (Long id);
    public Experience findExperience (Long id);
    
}
