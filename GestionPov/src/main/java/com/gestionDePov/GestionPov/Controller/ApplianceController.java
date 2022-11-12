package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.Model.Appliance;
import com.gestionDePov.GestionPov.Service.ApplianceService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ApplianceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/Appliance")

public class ApplianceController {
        private final ApplianceService appliance;



        @Autowired
        public ApplianceController(ApplianceImpl appliance) {
            this.appliance = appliance;
        }

        @GetMapping("/GetAppliance")
        public ApplianceDTO getAppliances(ApplianceDTO appliances) {
            return appliance.save(appliances);
        }

    }
