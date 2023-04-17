package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.dto.ProjectRequest;
import com.portfolio.GabrielMotta.model.Project;
import com.portfolio.GabrielMotta.service.IProjectService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pro")
public class ProjectController {
    
    @Autowired
    private IProjectService proServ;
    
    @PostMapping("/new")
    public void createProject (@RequestBody ProjectRequest proReq){
        this.proServ.createProject(proReq);
    }
    
    @GetMapping("/bring")
    @ResponseBody
    public List<Project> bringProjects(){
        return this.proServ.findProjects();
    }
    
    @DeleteMapping("/del/{id}")
    public void deleteProject(@PathVariable Long id){
        this.proServ.deleteProject(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateProject (@PathVariable Long id,
            @RequestBody Project pro){
        Project updatePro = this.proServ.findProject(id);
        BeanUtils.copyProperties(pro, updatePro);
        this.proServ.updateProject(updatePro);
        
    }
}
