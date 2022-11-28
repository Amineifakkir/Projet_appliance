package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import com.gestionDePov.GestionPov.Service.SuiviService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    public SuiviPageDTO findSuivi(@RequestParam int page, @RequestParam int size) {
        return suivi.findAll(PageRequest.of(page, size));
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
