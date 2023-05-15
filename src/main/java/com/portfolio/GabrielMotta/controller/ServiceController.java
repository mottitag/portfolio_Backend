package com.portfolio.GabrielMotta.controller;

import com.portfolio.GabrielMotta.model.Service;
import com.portfolio.GabrielMotta.service.IServiceService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("serv")
@CrossOrigin(origins = "https://porfolio-mottita.web.app")
public class ServiceController {
    
    @Autowired
    private IServiceService servServ;
    
    @GetMapping("/bring")
    @ResponseBody
    public List<Service> bringServices (){
        return this.servServ.findServices();
    }
        
    @DeleteMapping("/del/{id}")
    public void deleteService(@PathVariable Long id){
        this.servServ.deleteService(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateService(@PathVariable Long id,
            @RequestBody Service serv){
        Service updateSer = this.servServ.findService(id);
        BeanUtils.copyProperties(serv, updateSer);
        this.servServ.updateService(updateSer);
        
    }
}
