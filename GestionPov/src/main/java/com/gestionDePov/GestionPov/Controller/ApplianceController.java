package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.Service.ApplianceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appliance")
public class ApplianceController {
    @Autowired
        private  ApplianceService appliance;


    @PostMapping("/add")
    public ApplianceDTO getAppliances(@RequestBody ApplianceDTO appliances) {
        return appliance.save(appliances);
    }
    @GetMapping("/FindAppliance") //Get
    public List<ApplianceDTO> findAppliance() {
       return appliance.findAll();
    }
    @DeleteMapping("/DeleteType/{type}") //Delete
    public void deleteType(@PathVariable Long type) {
        appliance.delete(type);
    }


    @PutMapping("/Update/{idApp}") //Update
    public  ApplianceDTO updateAppliance(@PathVariable Long idApp, @RequestBody ApplianceDTO applianceDTO){
        return appliance.Update(idApp,applianceDTO);
    }

    }
