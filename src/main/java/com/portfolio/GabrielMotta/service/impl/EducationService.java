package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.dto.EducationRequest;
import com.portfolio.GabrielMotta.model.Education;
import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.repository.EducationRepository;
import com.portfolio.GabrielMotta.service.IEducationService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{

    @Autowired
    public EducationRepository eduRepo;
    private PersonService perServ;
    
    @Override
    public List<Education> findEducations() {
        return eduRepo.findAll();
    }

    @Override
    public void createEducation(EducationRequest eduReq) {
        Education edu = new Education();
        BeanUtils.copyProperties(eduReq, edu);
        
        Person per = perServ.findPerson(eduReq.getPersonId());
        per.addEducation(edu);
        perServ.updatePerson(per);
        
    }
    
    @Override
    public void updateEducation(Education edu){
        eduRepo.save(edu);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
}
