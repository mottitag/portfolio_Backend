package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.repository.ServiceRepository;
import com.portfolio.GabrielMotta.service.IServiceService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService implements IServiceService{
    
    @Autowired
    public ServiceRepository servRepo;
    
    @Override
    public List<com.portfolio.GabrielMotta.model.Service> findServices() {
        return servRepo.findAll();
    }

    @Override
    public void deleteService(Long id) {
        servRepo.deleteById(id);
    }

    @Override
    public com.portfolio.GabrielMotta.model.Service findService(Long id) {
        return servRepo.findById(id).orElse(null);
    }

    @Override
    public void updateService(com.portfolio.GabrielMotta.model.Service serv) {
        com.portfolio.GabrielMotta.model.Service updateSer = this.findService(serv.getId());
        BeanUtils.copyProperties(serv, updateSer);
        this.servRepo.save(updateSer);
    }
    
}
