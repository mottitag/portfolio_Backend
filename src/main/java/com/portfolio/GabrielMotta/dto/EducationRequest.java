package com.portfolio.GabrielMotta.dto;

import lombok.Data;

@Data
public class EducationRequest {
    
    private Long id;
    private String school;
    private String title;
    private String logo;
    private String despcription;
    private boolean isActualy;
    private String startDate;
    private String endDate;
    private Long personId;
    
}
