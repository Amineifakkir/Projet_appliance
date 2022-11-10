package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.Model.Appliance;
import com.gestionDePov.GestionPov.Repository.ApplianceRepo;
import com.gestionDePov.GestionPov.Service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplianceImpl implements ApplianceService {

    @Autowired
    ApplianceRepo applianceRepo;
    @Override
    public Appliance save(Appliance appliance) {

        return applianceRepo.save(appliance);
    }
}
