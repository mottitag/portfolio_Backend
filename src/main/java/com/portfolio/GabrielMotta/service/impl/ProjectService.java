package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.model.Project;
import com.portfolio.GabrielMotta.repository.ProjectRepository;
import com.portfolio.GabrielMotta.service.IProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{
    
    @Autowired
    public ProjectRepository proRepo;
    
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
    public void updateProject(Project pro) {
        this.proRepo.save(pro);
    }
    
    
    
}
