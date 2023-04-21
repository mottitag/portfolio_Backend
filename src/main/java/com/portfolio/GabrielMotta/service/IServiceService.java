package com.portfolio.GabrielMotta.service;

import com.portfolio.GabrielMotta.model.Service;
import java.util.List;


public interface IServiceService {
    
    public List<Service> findServices ();
    public void updateService (Service serReq);
    public void deleteService (Long id);
    public Service findService (Long id);
    
}
