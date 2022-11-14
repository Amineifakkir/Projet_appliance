package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.Service.ApplianceService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ApplianceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/Appliance")

public class ApplianceController {
        private final ApplianceService appliance;



        @Autowired
        public ApplianceController(ApplianceImpl appliance) {
            this.appliance = appliance;
        }

    @PostMapping("/GetAppliance")
        public ApplianceDTO getAppliances(ApplianceDTO appliances) {
            return appliance.save(appliances);
        }
    @GetMapping("/FindAppliance")
    public List<ApplianceDTO> findAppliance() {
       return appliance.findAll();
    }
    @DeleteMapping("/DeleteType/{type}")
    public void deleteType(@PathVariable("type") Long type) {
        appliance.delete(type);
    }


    @PutMapping("/Update/{idApp}")
    public  ApplianceDTO updateAppliance(@PathVariable("idApp") Long idApp, @RequestBody ApplianceDTO applianceDTO){
        return appliance.Update(idApp,applianceDTO);
    }

    }
