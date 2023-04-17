package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.dto.ServiceRequest;
import com.portfolio.GabrielMotta.model.Service;
import java.util.List;


public interface IServiceService {
    
    public List<Service> findServices ();
    public void createService (ServiceRequest serReq);
    public void updateService (ServiceRequest serReq);
    public void deleteService (Long id);
    public Service findService (Long id);
    
}
