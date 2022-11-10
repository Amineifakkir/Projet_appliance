package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Repository.PovRepo;
import com.gestionDePov.GestionPov.Service.PovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PovImpl implements PovService {
    @Autowired
    PovRepo povRepo;


    @Override
    public POV save(POV pov) {
        return povRepo.save(pov);
    }
}
