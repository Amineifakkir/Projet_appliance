package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;

import com.gestionDePov.GestionPov.DTO.TypePrestationPageDTO;
import com.gestionDePov.GestionPov.Service.TypePrestationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/TypePrestation")
public class TypePrestationController {
@Autowired
    private TypePrestationService typePrestation;


    @GetMapping("/Find")
    public TypePrestationPageDTO registerNewStudent(@RequestParam int page, @RequestParam int size){

        return typePrestation.findAlltype(PageRequest.of(page, size));

    }
    @PostMapping("/add")
    public TypePrestationDTO getType(@RequestBody TypePrestationDTO type) {
        return typePrestation.save(type);
    }

    @DeleteMapping("/Delete/{type}")
    public void deleteType(@PathVariable("type") Long type) {
        typePrestation.delete(type);
    }

    @PutMapping("/Update/{type}")
    public TypePrestationDTO UpdateType(@PathVariable("type") Long type,@RequestBody TypePrestationDTO typePrestationDTO){
    return typePrestation.Update(type,typePrestationDTO);
    }
}
