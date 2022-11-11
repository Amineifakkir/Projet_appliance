package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Model.Suivi;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import com.gestionDePov.GestionPov.Service.serviceImplementation.SuiviImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Suivi")
public class SuiviController {

    private final SuiviImpl suivi;
    @Autowired


    public SuiviController(SuiviImpl suivi) {
        this.suivi = suivi;
    }

    @GetMapping("/GetSuivi")
    public Suivi GetSuivi(Suivi suivis){
        return suivi.save(suivis);
    }
}
