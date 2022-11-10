package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Repository.SeanceRepo;
import com.gestionDePov.GestionPov.Service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeanceImpl implements SeanceService {

    @Autowired
    SeanceRepo seanceRepo;


    @Override
    public Seance save(Seance seance) {
        return seanceRepo.save(seance);
    }
}
