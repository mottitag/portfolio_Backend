package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.dto.ServiceRequest;
import com.portfolio.GabrielMotta.model.Service;
import com.portfolio.GabrielMotta.service.IServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("serv")
public class ServiceController {
    
    @Autowired
    private IServiceService servServ;
    
    @PostMapping("/new")
    public void createService(@RequestBody ServiceRequest servReq){
        this.servServ.createService(servReq);
    }
    
    @GetMapping("/bring")
    @ResponseBody
    public List<Service> bringServices (){
        return this.servServ.findServices();
    }
    
    
    @DeleteMapping("/del/{id}")
    public void deleteService(@PathVariable Long id){
        this.servServ.deleteService(id);
    }
    
    @PutMapping("/update")
    public void updateService(@RequestBody ServiceRequest serReq){
        this.servServ.updateService(serReq);
    }
}
