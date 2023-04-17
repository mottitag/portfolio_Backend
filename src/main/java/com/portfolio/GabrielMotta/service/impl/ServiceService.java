package com.portfolio.GabrielMotta.service.impl;

import com.portfolio.GabrielMotta.dto.ServiceRequest;
import com.portfolio.GabrielMotta.model.Person;
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
    private PersonService perServ;
    
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
    public void createService(ServiceRequest serReq) {
        com.portfolio.GabrielMotta.model.Service ser = new com.portfolio.GabrielMotta.model.Service();
        BeanUtils.copyProperties(serReq, ser);
        
        Person per = this.perServ.findPerson(serReq.getPersonId());
        per.addService(ser);
        this.perServ.updatePerson(per);
        
    }

    @Override
    public void updateService(ServiceRequest serReq) {
        com.portfolio.GabrielMotta.model.Service updateSer = this.findService(serReq.getId());
        BeanUtils.copyProperties(serReq, updateSer);
        this.servRepo.save(updateSer);
    }
    
}
