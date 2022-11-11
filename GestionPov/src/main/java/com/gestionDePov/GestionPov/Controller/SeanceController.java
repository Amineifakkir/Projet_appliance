package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import com.gestionDePov.GestionPov.Service.serviceImplementation.SeanceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Seance")
public class SeanceController {

    private final SeanceImpl seance;
    @Autowired


    public SeanceController(SeanceImpl seance) {
        this.seance= seance;
    }

    @GetMapping("/GetSeance")
    public Seance GetSeance(Seance seances){
        return seance.save(seances);
    }
}
