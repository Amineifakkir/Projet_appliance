package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.TypePrestation;
import com.gestionDePov.GestionPov.Service.TypePrestationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TypePrestation")
public class TypePrestationController {
    @Autowired
    private TypePrestationService typePrestation;

    @GetMapping("/GetTypePrestation")
    public TypePrestation GetTypePrestation(TypePrestation typePrestations){
        return typePrestation.save(typePrestations);
    }
    @GetMapping("/findAllType")
    public List<TypePrestation> registerNewStudent(){

        return typePrestation.findAll();

    }
    @PostMapping("/AddType")
    public TypePrestation getType(@RequestBody TypePrestation type) {
        return typePrestation.save(type);
    }
//    @DeleteMapping("/DeleteType/{type}")
//    public void deleteType(@PathVariable("type") Long type) {
//        typeService.delete(type);
//    }
}
