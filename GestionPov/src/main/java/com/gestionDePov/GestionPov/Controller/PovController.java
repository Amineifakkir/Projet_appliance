package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.POVDTO;

import com.gestionDePov.GestionPov.DTO.PovPageDto;
import com.gestionDePov.GestionPov.Service.PovService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Pov")
public class PovController {
    @Autowired
    private  PovService pov;


    @PostMapping("/add")
    public POVDTO getPOV(@RequestBody POVDTO povdto) {
        return pov.save(povdto);
    }
    @GetMapping("/Find")
    public PovPageDto findPOV(@RequestParam int page, @RequestParam int size) {
        return pov.findAll(PageRequest.of(page, size));
    }
    @DeleteMapping("/Delete/{idPov}")
    public void deletePov(@PathVariable("idPov") Long idPov) {
        pov.delete(idPov);
    }


    @PutMapping("/Update/{idPov}")
    public  POVDTO UpdatePovdto(@PathVariable Long idPv, @RequestBody POVDTO povdto){
        return pov.Update(idPv,povdto);
    }
}
