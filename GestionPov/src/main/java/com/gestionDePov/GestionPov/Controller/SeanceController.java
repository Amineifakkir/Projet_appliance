package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Service.SeanceService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import com.gestionDePov.GestionPov.Service.serviceImplementation.SeanceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Seance")
public class SeanceController {

    private final SeanceService seance;
    @Autowired


    public SeanceController(SeanceService seance) {
        this.seance= seance;
    }

    @GetMapping("/GetSeance")
    public SeanceDTO GetSeance(SeanceDTO seances){
        return seance.save(seances);
    }
}
