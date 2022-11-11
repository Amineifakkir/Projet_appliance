package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Service.TypeService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.TypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Type")
public class TypeController {
    @Autowired
    private TypeService typeService;

//    @GetMapping("/findAllType")
//    public List<TypeDTO> registerNewStudent(){
//
////       return typeService.findAll(List<TypeDTO>);
//
//    }
     @PostMapping("/AddType")
    public TypeDTO getType(@RequestBody TypeDTO type) {
        return typeService.save(type);
    }
    @DeleteMapping("/DeleteType/{type}")
    public void deleteType(@PathVariable("type") Long type) {
        typeService.delete(type);
    }



}
