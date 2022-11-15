package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Service.PovService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.PovImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pov")
public class PovController {
    @Autowired
    private  PovService pov;


    @PostMapping("/GetPov")
    public POVDTO getPOV(@RequestBody POVDTO povdto) {
        return pov.save(povdto);
    }
    @GetMapping("/FindPOV")
    public List<POVDTO> findPOV() {
        return pov.findAll();
    }
    @DeleteMapping("/DeleteType/{idPov}")
    public void deletePov(@PathVariable("idPov") Long idPov) {
        pov.delete(idPov);
    }


    @PutMapping("/Update/{idPov}")
    public  POVDTO UpdatePovdto(@PathVariable("idPov") Long idPv, @RequestBody POVDTO povdto){
        return pov.Update(idPv,povdto);
    }
}
