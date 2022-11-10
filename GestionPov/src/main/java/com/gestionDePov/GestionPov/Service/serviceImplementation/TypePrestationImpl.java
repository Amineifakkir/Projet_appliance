package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.TypePrestation;
import com.gestionDePov.GestionPov.Repository.TypePrestationRepo;
import com.gestionDePov.GestionPov.Service.TypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypePrestationImpl implements TypePrestationService {
    @Autowired
    TypePrestationRepo typePrestationRepo;
    @Override
    public TypePrestation save(TypePrestation typePrestation) {
        return typePrestationRepo.save(typePrestation);
    }
}
