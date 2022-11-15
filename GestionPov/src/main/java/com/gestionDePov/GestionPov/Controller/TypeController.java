package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Type")
public class TypeController {
@Autowired
    private  TypeService typeService;

    @GetMapping
    public List<TypeDTO> registerNewStudent(){

        return typeService.findAllType();

    }


    @PostMapping
    public TypeDTO getType(@RequestBody TypeDTO type) {
        return typeService.save(type);
    }
    @DeleteMapping("/DeleteType/{type}")
    public void deleteType(@PathVariable("type") Long type) {
        typeService.delete(type);
    }


    @PutMapping("/Update/{type}")
    public TypeDTO UpdateType(@PathVariable Long type, @RequestBody TypeDTO typeDTO){
        return typeService.Update(type,typeDTO);
    }
}
