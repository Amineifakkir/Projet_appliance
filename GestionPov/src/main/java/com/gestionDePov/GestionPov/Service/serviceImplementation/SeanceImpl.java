package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Repository.SeanceRepo;
import com.gestionDePov.GestionPov.Service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;

public class SeanceImpl implements SeanceService {

    @Autowired
    SeanceRepo seanceRepo;


    @Override
    public Seance save(Seance seance) {
        return seanceRepo.save(seance);
    }
}
