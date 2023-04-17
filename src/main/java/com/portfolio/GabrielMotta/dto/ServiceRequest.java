package com.portfolio.GabrielMotta.dto;

import lombok.Data;

@Data
public class ServiceRequest {
    
    private Long id;
    private String name;
    private String description;
    private Long personId;
    
}
