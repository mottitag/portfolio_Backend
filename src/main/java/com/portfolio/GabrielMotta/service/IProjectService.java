package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.model.Project;
import java.util.List;


public interface IProjectService {
    
    public List<Project> findProjects ();
    public void updateProject (Project pro);
    public void deleteProject (Long id);
    public Project findProject (Long id);
    
}
