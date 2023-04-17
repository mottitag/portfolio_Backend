package com.portfolio.GabrielMotta.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String foto;
    private String phone;
    private String title;
    private String descrition;
    
    @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pp_fk", referencedColumnName = "id")
    private List<Project> projects;
    @OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pe_fk", referencedColumnName = "id")
    private List<Experience> experiences;
    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pe_fk", referencedColumnName = "id")
    private List<Education> educations;
    @OneToMany(targetEntity = Service.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ps_fk", referencedColumnName = "id")
    private List<Service> services;
    @OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "psk_fk", referencedColumnName = "id")
    private List<Skill> skills;
    
    public void addEducation (Education edu){
        this.educations.add(edu);
    }
    
    public void addExperience (Experience exp){
        this.experiences.add(exp);
    }
    
    public void addProject (Project pro){
        this.projects.add(pro);
    }
    
    public void addService (Service serv){
        this.services.add(serv);
    }
    
    public void addSkill (Skill ski){
        this.skills.add(ski);
    }
    
}
