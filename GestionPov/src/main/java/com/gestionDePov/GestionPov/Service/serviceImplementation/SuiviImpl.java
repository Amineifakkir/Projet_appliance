package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.Suivi;
import com.gestionDePov.GestionPov.Repository.SuiviRepo;
import com.gestionDePov.GestionPov.Service.SuiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SuiviImpl implements SuiviService {
    @Autowired
    SuiviRepo suiviRepo;
    @Override
    public Suivi save(Suivi suivi) {
        return suiviRepo.save(suivi);
    }
}
