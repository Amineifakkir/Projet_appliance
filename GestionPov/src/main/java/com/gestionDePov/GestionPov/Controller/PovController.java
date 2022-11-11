package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Pov")
public class PovController {
    private final PovImpl pov;
@Autowired
    public PovController(PovImpl pov) {
        this.pov = pov;
    }

    @GetMapping("/GetPov")
    public POV GetPov(POV povs){
    return pov.save(povs);
    }
}
