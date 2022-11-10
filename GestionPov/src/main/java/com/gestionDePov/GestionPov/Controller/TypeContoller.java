package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Type")
public class TypeContoller {
private final ServiceType serviceType;

    @Autowired
    public TypeContoller(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @GetMapping
    public List<Type> getType() {
        return serviceType.Type();
    }




}
