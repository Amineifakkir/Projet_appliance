package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Type")
public class TypeController {

    public TypeService typeService;
//    @GetMapping("/findAllType")
//    public List<TypePrestationDTO> registerNewStudent(){
//
//        return typeService.findAlltype();
//
//    }

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


    @PutMapping("/Update")
    public TypeDTO UpdateType(@PathVariable("type") Long type, @RequestBody TypeDTO typeDTO){
        return typeService.Update(type,typeDTO);
    }
}
