package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.DTO.SuiviDTO;
import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Model.Suivi;
import com.gestionDePov.GestionPov.Service.SuiviService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import com.gestionDePov.GestionPov.Service.serviceImplementation.SuiviImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Suivi")
public class SuiviController {
@Autowired
    private  SuiviService suivi;


    @PostMapping("/GetSuivi")
    public SuiviDTO getSuivi(@RequestBody SuiviDTO suiviDTO) {
        return suivi.save(suiviDTO);
    }
    @GetMapping("/FindSuivi")
    public List<SuiviDTO> findSuivi() {
        return suivi.findAll();
    }
    @DeleteMapping("/DeleteType/{idSuivi}")
    public void deleteSuivi(@PathVariable("idSuivi") Long idSuivi) {
        suivi.delete(idSuivi
        );
    }


    @PutMapping("/Update/{idSuivi}")
    public SuiviDTO updateSuivi(@PathVariable("idSuivi") Long idSuivi, @RequestBody SuiviDTO suiviDTO){
        return suivi.Update(idSuivi,suiviDTO);
    }
}
