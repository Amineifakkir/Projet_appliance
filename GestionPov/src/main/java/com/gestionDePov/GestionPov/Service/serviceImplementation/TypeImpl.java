package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeImpl implements TypeService {
    @Autowired
    TypeRepo typeRepo;
    @Override
    public Type save(Type type) {
        return typeRepo.save(type);
    }
}
