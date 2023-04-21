package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.model.Experience;
import com.portfolio.GabrielMotta.repository.ExperienceRepository;
import com.portfolio.GabrielMotta.service.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{
    
    @Autowired
    public ExperienceRepository expRepo;

    @Override
    public List<Experience> findExperiences() {
        return expRepo.findAll();
    }

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public void updaateExperience(Experience exp) {
        expRepo.save(exp);
    }
    
}
