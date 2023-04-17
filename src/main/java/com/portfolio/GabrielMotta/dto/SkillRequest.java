package com.portfolio.GabrielMotta.dto;

import lombok.Data;

@Data
public class SkillRequest {
    
    private Long id;
    private String name;
    private Long percent;
    private String color;
    private Long personId;
     
}
