package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.dto.ExperienceRequest;
import com.portfolio.GabrielMotta.model.Experience;
import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.repository.ExperienceRepository;
import com.portfolio.GabrielMotta.service.IExperienceService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{
    
    @Autowired
    public ExperienceRepository expRepo;
    private PersonService perServ;

    @Override
    public List<Experience> findExperiences() {
        return expRepo.findAll();
    }

    @Override
    public void createExperience(ExperienceRequest expReq) {
        Experience exp = new Experience();
        BeanUtils.copyProperties(expReq, exp);
        
        Person per = perServ.findPerson(expReq.getPersonId());
        per.addExperience(exp);
        perServ.updatePerson(per);
        
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
