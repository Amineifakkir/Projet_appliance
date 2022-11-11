package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.Appliance;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ApplianceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/Appliance")

public class ApplianceController {
        private final ApplianceImpl appliance;



        @Autowired
        public ApplianceController(ApplianceImpl appliance) {
            this.appliance = appliance;
        }

        @GetMapping("/GetAppliance")
        public Appliance getAppliances(Appliance appliances) {
            return appliance.save(appliances);
        }

    }
