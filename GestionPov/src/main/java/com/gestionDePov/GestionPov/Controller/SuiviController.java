package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import com.gestionDePov.GestionPov.Service.SuiviService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Suivi")
public class SuiviController {
@Autowired
    private  SuiviService suivi;


    @PostMapping("/add")
    public SuiviDTO getSuivi(@RequestBody SuiviDTO suiviDTO) {
        return suivi.save(suiviDTO);
    }
    @GetMapping("/Find")
    public List<SuiviDTO> findSuivi() {
        return suivi.findAll();
    }
    @DeleteMapping("/Delete/{idSuivi}")
    public void deleteSuivi(@PathVariable("idSuivi") Long idSuivi) {
        suivi.delete(idSuivi
        );
    }


    @PutMapping("/Update/{idSuivi}")
    public SuiviDTO updateSuivi(@PathVariable("idSuivi") Long idSuivi, @RequestBody SuiviDTO suiviDTO){
        return suivi.Update(idSuivi,suiviDTO);
    }
}
