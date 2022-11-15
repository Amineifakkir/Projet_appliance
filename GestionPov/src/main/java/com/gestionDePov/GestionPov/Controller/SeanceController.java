package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Service.SeanceService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import com.gestionDePov.GestionPov.Service.serviceImplementation.SeanceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Seance")
public class SeanceController {
@Autowired
    private SeanceService seance;


    @PostMapping("/GetSeance")
    public SeanceDTO getSeance(@RequestBody SeanceDTO seanceDTO) {
        return seance.save(seanceDTO);
    }
    @GetMapping("/FindPOV")
    public List<SeanceDTO> findSeance() {
        return seance.findAll();
    }
    @DeleteMapping("/DeleteType/{idSeance}")
    public void deleteSeance(@PathVariable("idSeance") Long idSeance) {
        seance.delete(idSeance);
    }


    @PutMapping("/Update/{idSeance}")
    public  SeanceDTO updateSeance(@PathVariable("idSeance") Long idSeance, @RequestBody SeanceDTO seanceDTO){
        return seance.Update(idSeance,seanceDTO);
    }
}
