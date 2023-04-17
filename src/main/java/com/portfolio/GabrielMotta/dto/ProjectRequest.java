package com.portfolio.GabrielMotta.dto;

import lombok.Data;

@Data
public class ProjectRequest {
    
    private Long id;
    private String name;
    private String photo;
    private String description;
    private Long personId;
    
}
