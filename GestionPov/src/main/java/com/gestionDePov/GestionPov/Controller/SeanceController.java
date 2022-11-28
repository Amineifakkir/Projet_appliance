package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.SeanceDTO;

import com.gestionDePov.GestionPov.DTO.SeancePageDTO;
import com.gestionDePov.GestionPov.Service.SeanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Seance")
public class SeanceController {
@Autowired
    private SeanceService seance;


    @PostMapping("/add")
    public SeanceDTO getSeance(@RequestBody SeanceDTO seanceDTO) {
        return seance.save(seanceDTO);
    }
    @GetMapping("/Find")
    public SeancePageDTO findSeance(@RequestParam int page, @RequestParam int size) {
        return seance.findAll(PageRequest.of(page, size));
    }
    @DeleteMapping("/Delete/{idSeance}")
    public void deleteSeance(@PathVariable("idSeance") Long idSeance) {
        seance.delete(idSeance);
    }


    @PutMapping("/Update/{idSeance}")
    public  SeanceDTO updateSeance(@PathVariable("idSeance") Long idSeance, @RequestBody SeanceDTO seanceDTO){
        return seance.Update(idSeance,seanceDTO);
    }
}
