package com.portfolio.GabrielMotta.dto;

import lombok.Data;

@Data
public class ExperienceRequest {
    
    private Long id;
    private String company;
    private String position;
    private String logo;
    private String description;
    private boolean isActualy;
    private String startDate;
    private String endDate;
    private Long personId;
    
}
