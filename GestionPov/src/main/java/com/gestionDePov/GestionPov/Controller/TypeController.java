package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Service.serviceImplementation.TypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Type")
public class TypeController {
private final TypeImpl typeimpl;

    @Autowired
    public TypeController(TypeImpl typeimpl) {
        this.typeimpl = typeimpl;
    }
     @GetMapping("/GetType")
    public Type getType(Type type) {
        return typeimpl.save(type);
    }




}
