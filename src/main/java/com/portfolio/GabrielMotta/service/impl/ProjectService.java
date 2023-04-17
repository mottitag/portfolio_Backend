package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.dto.ProjectRequest;
import com.portfolio.GabrielMotta.model.Person;
import com.portfolio.GabrielMotta.model.Project;
import com.portfolio.GabrielMotta.repository.ProjectRepository;
import com.portfolio.GabrielMotta.service.IProjectService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{
    
    @Autowired
    public ProjectRepository proRepo;
    private PersonService perServ;
    
    @Override
    public List<Project> findProjects() {
        return this.proRepo.findAll();
    }

    @Override
    public void deleteProject(Long id) {
        this.proRepo.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        return this.proRepo.findById(id).orElse(null);
    }

    @Override
    public void createProject(ProjectRequest proReq) {
        Project pro = new Project();
        BeanUtils.copyProperties(proReq, pro);
        
        Person per = this.perServ.findPerson(proReq.getPersonId());
        per.addProject(pro);
        this.perServ.updatePerson(per);
        
    }

    @Override
    public void updateProject(Project pro) {
        this.proRepo.save(pro);
    }
    
    
    
}
