package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.model.Education;
import java.util.List;


public interface IEducationService {
    
    public List<Education> findEducations ();
    public void updateEducation (Education edu);
    public void deleteEducation (Long id);
    public Education findEducation (Long id);
    
}
